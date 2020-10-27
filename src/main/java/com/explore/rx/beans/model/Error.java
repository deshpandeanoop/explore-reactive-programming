package com.explore.rx.beans.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error {

    @JsonProperty("code")
    private String code;

    @JsonProperty("category")
    private String category;

    @JsonProperty("description")
    private String description;
}