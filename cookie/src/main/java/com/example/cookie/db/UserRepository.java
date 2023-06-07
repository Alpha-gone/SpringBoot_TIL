package com.example.cookie.db;

import com.example.cookie.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepository {
    private final List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findById(String id){
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<UserDto> findByName(String name){
        return userList.stream().filter(user -> user.getName().equals(name)).findFirst();
    }

    @PostConstruct
    public void init(){
        userList.add(
                UserDto.builder()
                        .name("홍길동")
                        .id(UUID.randomUUID().toString())
                        .password("1234")
                        .build()
        );

        userList.add(
                UserDto.builder()
                        .name("유관순")
                        .id(UUID.randomUUID().toString())
                        .password("1234")
                        .build()
        );

        userList.add(
                UserDto.builder()
                        .name("철수")
                        .id(UUID.randomUUID().toString())
                        .password("1234")
                        .build()
        );
    }
}
