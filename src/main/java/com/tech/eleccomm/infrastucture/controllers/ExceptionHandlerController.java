package com.tech.eleccomm.infrastucture.controllers;

import com.tech.eleccomm.application.exceptions.NotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(final NotFoundException exception) {
        log.warn("Not found Exception: ", exception);
        return this.makeErrorResponseEntity(exception);
    }

    private ResponseEntity<ErrorResponse> makeErrorResponseEntity(final NotFoundException errorResult) {
        return ResponseEntity.status(errorResult.getCode())
                .body(new ErrorResponse(String.valueOf(errorResult.getCode()), errorResult.getMessage()));
    }

    @Getter
    @RequiredArgsConstructor
    static class ErrorResponse {
        private final String code;
        private final String message;
    }
}
