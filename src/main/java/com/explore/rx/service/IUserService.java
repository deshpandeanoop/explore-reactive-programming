package com.explore.rx.service;

import com.explore.rx.beans.model.User;
import java.util.List;

public interface IUserService {

    /**
     * Fetches all users from json place holder service
     * @return
     */
    List<User> fetchAll();

    /**
     * Fetches user for given Id from json place holder service
     * @param userId
     * @return
     */
    User fetchById(Integer userId);
}