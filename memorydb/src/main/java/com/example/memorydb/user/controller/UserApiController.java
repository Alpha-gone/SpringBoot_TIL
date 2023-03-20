package com.example.memorydb.user.controller;


import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }

    @GetMapping("/id/{id}")
    public UserEntity findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(@RequestParam int score){
        return userService.filterScore(score);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
