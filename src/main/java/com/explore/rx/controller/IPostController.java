package com.explore.rx.controller;

import com.explore.rx.beans.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/posts")
public interface IPostController {

    /**
     * Fetches all posts of all users from the system
     * @return
     */
    @GetMapping
    List<Post> fetchAll();
}
