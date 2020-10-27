package com.explore.rx.controller;

import com.explore.rx.beans.model.Post;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/posts")
public interface IPostController {

    /**
     * Fetches all posts of all users from the system
     * @return
     */
    @GetMapping
    Publisher<Post> fetchAll();
}
