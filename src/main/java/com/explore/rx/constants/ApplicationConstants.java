package com.explore.rx.constants;

public enum ApplicationConstants {
    FORWARD_SLASH("/");

    private String value;

    ApplicationConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}