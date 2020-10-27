package com.explore.rx.service;

import com.explore.rx.beans.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

    /**
     * Fetches all users from json place holder service
     * @return
     */
    Flux<User> fetchAll();

    /**
     * Fetches user for given Id from json place holder service
     * @param userId
     * @return
     */
    Mono<User> fetchById(Integer userId);
}