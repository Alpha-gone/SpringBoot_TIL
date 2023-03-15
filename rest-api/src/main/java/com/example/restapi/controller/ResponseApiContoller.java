package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiContoller {
//    @GetMapping("")
//    public ResponseEntity<UserRequest> user(){
//        var user = new UserRequest();
//
//        user.setUserName("홍길동");
//        user.setUserAge(10);
//        user.setEmail("hong@gmail.com");
//
//        log.info("user : {}", user);
//
//        var response = ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .header("x-custom", "hi")
//                .body(user);
//
//        return response;
//    }
}
