package com.explore.rx.beans.response;

import com.explore.rx.beans.model.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {

    @JsonProperty("errors")
    private final List<Error> errors = new ArrayList<>();
}
