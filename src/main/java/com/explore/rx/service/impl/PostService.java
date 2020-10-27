package com.explore.rx.service.impl;

import com.explore.rx.beans.model.Post;
import com.explore.rx.constants.ApplicationConstants;
import com.explore.rx.constants.JsonPlaceHolderResources;
import com.explore.rx.exceptions.InternalServiceException;
import com.explore.rx.service.ICommentService;
import com.explore.rx.service.IPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class PostService extends BaseJsonPlaceHolderService implements IPostService {

    @Autowired
    private ICommentService commentService;

    public PostService(@Autowired WebClient.Builder webClientBuilder) {
        super(webClientBuilder);
    }

    /**
     * Fetches all posts from json placeholder service
     *
     * @return
     */
    @Override
    public Flux<Post> fetchAll() {
        log.info("Calling json placeholder service to fetch all posts");
        return webClientBuilder
                .baseUrl(jsonPlaceHolderApiBaseUrl)
                .build()
                .get()
                .uri(JsonPlaceHolderResources.POSTS.getUri())
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    log.error("Internal service error received from json place holder service for fetch all posts call. Here is the message");
                    return Mono.just(new InternalServiceException("Internal service error occurred while fetching all posts from the system"));
                })
                .bodyToFlux(Post.class);
    }

    /**
     * Fetches all posts for a given user from json place holder service
     *
     * @param userId
     * @return
     */
    @Override
    public Mono<List<Post>> fetchByUserId(Integer userId) {
        log.info("Calling json placeholder service to fetch posts for UserId : {}", userId);
        Mono<List<Post>> postsMono = webClientBuilder
                .baseUrl(jsonPlaceHolderApiBaseUrl)
                .build()
                .get()
                .uri(JsonPlaceHolderResources.USERS.getUri()
                        + ApplicationConstants.FORWARD_SLASH.getValue()
                        + userId
                        + JsonPlaceHolderResources.POSTS.getUri())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Post>>() {
                });

        return postsMono
                .flatMap(posts -> {
                   return Flux.just(posts.toArray(new Post[0]))
                           .flatMap(Mono::just)
                           .flatMap(post -> {
                                return commentService.fetchByPostId(post.getId())
                                       .flatMap(comments -> {
                                           post.getComments().addAll(comments);
                                           return Mono.just(post);
                                       });
                           }).collectList();
                });
    }
}