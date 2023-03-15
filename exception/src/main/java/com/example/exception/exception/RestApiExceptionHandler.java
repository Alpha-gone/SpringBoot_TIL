package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackageClasses = {RestApiBController.class})
@Order(1)
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Api> exception(Exception e){
        log.error("RestApiExceptionHandler", e);

        var response = Api.builder()
                .resultCode(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("IndexOutOfBoundsException", e);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElement(NoSuchElementException e){
        log.error("",e);

        var response = Api.builder()
                .resultCode(Integer.toString(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
}
