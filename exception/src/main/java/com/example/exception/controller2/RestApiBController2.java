package com.example.exception.controller2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/2/b")
public class RestApiBController2 {
    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("number format exception");
    }

//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity numberFormatException(NumberFormatException e){
//        log.error("RestApiBController2", e);
//
//        return ResponseEntity.ok().build();
//    }
}
