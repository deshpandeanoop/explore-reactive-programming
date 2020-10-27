package com.explore.rx.service;

import com.explore.rx.beans.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IPostService {

    /**
     * Fetches all posts from json placeholder service
     *
     * @return
     */
    Flux<Post> fetchAll();

    /**
     * Fetches all posts of given user from json place holder service
     *
     * @param userId
     * @return
     */
    Mono<List<Post>> fetchByUserId(Integer userId);
}