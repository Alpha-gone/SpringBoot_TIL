package com.example.aop.controller;


import com.example.aop.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public UserRequest register(@RequestBody UserRequest request ){
        log.info("{}",request);

//        throw new NumberFormatException("");
        return request;
    }

    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }
}
