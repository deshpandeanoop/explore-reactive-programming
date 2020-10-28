package com.explore.rx.service;

import com.explore.rx.beans.model.Post;
import java.util.List;

public interface IPostService {

    /**
     * Fetches all posts from json placeholder service
     *
     * @return
     */
    List<Post> fetchAll();

    /**
     * Fetches all posts of given user from json place holder service
     *
     * @param userId
     * @return
     */
    List<Post> fetchByUserId(Integer userId);
}