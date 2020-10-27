package com.explore.rx.constants;

public enum JsonPlaceHolderResources {
    POSTS("/posts"), USERS("/users"), COMMENTS("/comments");

    private String uri;

    JsonPlaceHolderResources(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}