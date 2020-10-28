package com.explore.rx.controller.impl;

import com.explore.rx.beans.model.User;
import com.explore.rx.controller.IUserController;
import com.explore.rx.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final IUserService userService;

    /**
     * Fetches all users present in the system
     * @return
     */
    @Override
    public List<User> fetchAll() {
        log.debug("Received request for fetchAllUsers");
        return userService.fetchAll();
    }

    /**
     * Fetches user for given Id
     * @param userId
     * @return
     */
    @Override
    public User fetchById(Integer userId) {
        log.debug("Received fetchUser request for Id : {}", userId);
        return userService.fetchById(userId);
    }
}