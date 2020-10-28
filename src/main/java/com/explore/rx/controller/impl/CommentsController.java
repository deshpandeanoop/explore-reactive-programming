package com.explore.rx.controller.impl;

import com.explore.rx.beans.model.Comment;
import com.explore.rx.controller.ICommentsController;
import com.explore.rx.service.ICommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentsController implements ICommentsController {

    private final ICommentService commentService;

    @Override
    public List<Comment> fetchAll() {
        log.debug("Received fetchAll comments requests");
        return commentService.fetchAll();
    }
}
