package com.explore.rx.service;

import com.explore.rx.beans.model.Comment;

import java.util.List;

public interface ICommentService {

    /**
     * Fetches all comments posted by users from json place holder service
     * @return
     */
    List<Comment> fetchAll();

    /**
     * Fetches all comments for given a post from json place holder service
     * @param postId
     * @return
     */
    List<Comment> fetchByPostId(Integer postId);
}