package com.explore.rx.beans.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserCompany {

    @JsonProperty("name")
    private String name;

    @JsonProperty("catchPhrase")
    private String catchPhrase;

    @JsonProperty("bs")
    private String bs;
}
