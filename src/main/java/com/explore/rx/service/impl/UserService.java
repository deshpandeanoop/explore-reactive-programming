package com.explore.rx.service.impl;

import com.explore.rx.beans.model.Post;
import com.explore.rx.beans.model.User;
import com.explore.rx.constants.ApplicationConstants;
import com.explore.rx.constants.JsonPlaceHolderResources;
import com.explore.rx.exceptions.InternalServiceException;
import com.explore.rx.exceptions.UserNotFoundException;
import com.explore.rx.service.IPostService;
import com.explore.rx.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService extends BaseJsonPlaceHolderService implements IUserService {

    @Autowired
    private IPostService postService;

    public UserService(@Autowired WebClient.Builder webClientBuilder) {
        super(webClientBuilder);
    }

    /**
     * Fetches all users from Json place holder service
     *
     * @return
     */
    @Override
    public Flux<User> fetchAll() {
        log.info("Calling json place holder service to fetch all users");
        return webClientBuilder
                .baseUrl(jsonPlaceHolderApiBaseUrl)
                .build()
                .get()
                .uri(JsonPlaceHolderResources.USERS.getUri())
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    log.error("Internal service error received from json place holder service for fetch all users call. Here is the message");
                    return Mono.just(new InternalServiceException("Internal service error occurred while fetching all users from the system"));
                })
                .bodyToFlux(User.class);
    }

    /**
     * Fetches user with given id from json place holder service
     *
     * @param userId
     * @return
     */
    @Override
    public Mono<User> fetchById(Integer userId) {
        log.info("Calling json place holder service with User Id : {}", userId);
        Mono<User> userMono = webClientBuilder
                .baseUrl(jsonPlaceHolderApiBaseUrl)
                .build()
                .get()
                .uri(JsonPlaceHolderResources.USERS.getUri() + "/" + userId)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                    log.error("User with Id {} not found in json place holder service", userId);
                    return Mono.just(new UserNotFoundException("User " + userId + " is not found. Please pass valid user Id. To get all users in the system, use '/users' endpoint"));
                })
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    log.error("Internal service error received from json place holder service for fetch all users call. Here is the message");
                    return Mono.just(new InternalServiceException("Internal service error occurred while fetching all users from the system"));
                })
                .bodyToMono(User.class);

       return Mono.zip(userMono, postService.fetchByUserId(userId), (user, posts) -> {
           user.getPosts().addAll(posts);
           return user;
       });
    }
}