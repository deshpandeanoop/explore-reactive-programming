package com.explore.rx.controller;

import com.explore.rx.beans.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/users")
public interface IUserController {

    /**
     * Fetches all users present in the system
     * @return
     */
    @GetMapping
    List<User> fetchAll();

    /**
     * Fetches user detail for given Id
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    User fetchById(@PathVariable("userId") Integer userId);
}
