package com.explore.rx.advice;

import com.explore.rx.beans.model.Error;
import com.explore.rx.beans.response.ErrorResponse;
import com.explore.rx.constants.ErrorCategory;
import com.explore.rx.exceptions.InternalServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
public class BaseControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServiceException.class)
    public Mono<ErrorResponse> handleInternalServiceException(InternalServiceException internalServiceException) {
        log.info("Building internal service error response");
       return Mono.just(buildErrorResponse(internalServiceException));
    }

    private ErrorResponse buildErrorResponse(InternalServiceException internalServiceException) {
        Error error = new Error();
        error.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        error.setCategory(ErrorCategory.SYSTEM_ERROR.name());
        error.setDescription(internalServiceException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.getErrors().add(error);
        return errorResponse;
    }
}