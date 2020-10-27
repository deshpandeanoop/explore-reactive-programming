package com.explore.rx.controller;

import com.explore.rx.beans.model.Comment;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/comments")
public interface ICommentsController {

    /**
     * Fetches all comments from the system
     * @return
     */
    @GetMapping
    Publisher<Comment> fetchAll();
}