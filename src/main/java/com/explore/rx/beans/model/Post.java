package com.explore.rx.beans.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Post {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("comments")
    private List<Comment> comments = new ArrayList<>();
}