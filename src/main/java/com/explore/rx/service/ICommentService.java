package com.explore.rx.service;

import com.explore.rx.beans.model.Comment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICommentService {

    /**
     * Fetches all comments posted by users from json place holder service
     * @return
     */
    Flux<Comment> fetchAll();

    /**
     * Fetches all comments for given a post from json place holder service
     * @param postId
     * @return
     */
    Mono<List<Comment>> fetchByPostId(Integer postId);
}