package com.explore.rx.controller;

import com.explore.rx.beans.model.Comment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/comments")
public interface ICommentsController {

    /**
     * Fetches all comments from the system
     * @return
     */
    @GetMapping
    List<Comment> fetchAll();
}