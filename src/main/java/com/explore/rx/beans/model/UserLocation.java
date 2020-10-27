package com.explore.rx.beans.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserLocation {

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("lng")
    private String longitude;
}
