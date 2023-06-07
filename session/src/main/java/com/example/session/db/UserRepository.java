package com.example.session.db;

import com.example.session.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository {
    private List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findByName(String name){
        return userList.stream().filter(user -> user.getName().equals(name)).findFirst();
    }

    @PostConstruct
    public void init(){
        userList.add(
                UserDto.builder()
                        .name("홍길동")
                        .password("1234")
                        .build()
        );

        userList.add(
                UserDto.builder()
                        .name("유관순")
                        .password("1234")
                        .build()
        );

        userList.add(
                UserDto.builder()
                        .name("철수")
                        .password("1234")
                        .build()
        );
    }
}
