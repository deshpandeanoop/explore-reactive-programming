package com.explore.rx.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class BaseJsonPlaceHolderService {

    protected final WebClient.Builder webClientBuilder;

    @Value("${json.placeholder.api.base.url}")
    protected String jsonPlaceHolderApiBaseUrl;
}
