package com.explore.rx.controller.impl;

import com.explore.rx.beans.model.Post;
import com.explore.rx.controller.IPostController;
import com.explore.rx.service.IPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PostController implements IPostController {

    private final IPostService postService;

    /**
     * Fetches all posts of all users from the system
     * @return
     */
    @Override
    public Publisher<Post> fetchAll() {
        log.debug("Received fetchAllPosts call");
        return postService.fetchAll();
    }
}
