package com.explore.rx.service.impl;

import com.explore.rx.beans.model.Comment;
import com.explore.rx.constants.ApplicationConstants;
import com.explore.rx.constants.JsonPlaceHolderResources;
import com.explore.rx.exceptions.InternalServiceException;
import com.explore.rx.service.ICommentService;
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
public class CommentService extends BaseJsonPlaceHolderService implements ICommentService {

    public CommentService(@Autowired WebClient.Builder webClientBuilder) {
        super(webClientBuilder);
    }

    @Override
    public Flux<Comment> fetchAll() {
        log.info("Calling json place holder service to fetch all comments");
        return webClientBuilder
                .baseUrl(jsonPlaceHolderApiBaseUrl)
                .build()
                .get()
                .uri(JsonPlaceHolderResources.COMMENTS.getUri())
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    log.error("Internal service error received from json place holder service for fetch all comments resource call");
                    return Mono.just(new InternalServiceException("Internal service error occurred while fetching all users from the system"));
                })
                .bodyToFlux(Comment.class);
    }

    @Override
    public Mono<List<Comment>> fetchByPostId(Integer postId) {
        log.info("Calling json place holder service for PostId : {}", postId);
        return webClientBuilder
                .baseUrl(jsonPlaceHolderApiBaseUrl)
                .build()
                .get()
                .uri(JsonPlaceHolderResources.POSTS.getUri()
                + ApplicationConstants.FORWARD_SLASH.getValue()
                + postId
                + JsonPlaceHolderResources.COMMENTS.getUri())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Comment>>() {});
    }
}