package com.explore.rx.beans.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAddress {

    @JsonProperty("street")
    private String street;

    @JsonProperty("suite")
    private String suite;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zipcode")
    private String zipCode;

    @JsonProperty("geo")
    private UserLocation location;

}