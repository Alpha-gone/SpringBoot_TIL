package com.example.post.controller;

import com.example.post.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        requestData.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
            System.out.println();

        });
    }

    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDTO postRequestDTO){
        System.out.println(postRequestDTO);
    }
}
