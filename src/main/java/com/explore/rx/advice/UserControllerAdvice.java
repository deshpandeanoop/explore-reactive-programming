package com.explore.rx.advice;

import com.explore.rx.beans.model.Error;
import com.explore.rx.beans.response.ErrorResponse;
import com.explore.rx.constants.ErrorCategory;
import com.explore.rx.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
public class UserControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Mono<ErrorResponse> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        log.error("Building error response for user not found exception");
        return Mono.just(buildErrorResponse(userNotFoundException));
    }

    private ErrorResponse buildErrorResponse(UserNotFoundException userNotFoundException) {
        Error error = new Error();
        error.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.setCategory(ErrorCategory.DATA.name());
        error.setDescription(userNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.getErrors().add(error);
        return errorResponse;
    }
}
