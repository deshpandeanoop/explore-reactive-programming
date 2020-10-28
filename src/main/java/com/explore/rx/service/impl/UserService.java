package com.explore.rx.service.impl;

import com.explore.rx.beans.model.User;
import com.explore.rx.constants.JsonPlaceHolderResources;
import com.explore.rx.service.IPostService;
import com.explore.rx.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final RestTemplate restTemplate;
    private final IPostService postService;

    /**
     * Fetches all users from Json place holder service
     *
     * @return
     */
    @Override
    public List<User> fetchAll() {
        log.info("Calling json place holder service to fetch all users");
        return restTemplate.exchange(JsonPlaceHolderResources.USERS.getUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        }).getBody();
    }

    /**
     * Fetches user with given id from json place holder service
     *
     * @param userId
     * @return
     */
    @Override
    public User fetchById(Integer userId) {
        log.info("Calling json place holder service with User Id : {}", userId);
        return null;
    }
}