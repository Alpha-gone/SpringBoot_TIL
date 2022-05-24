package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    //get 이름 사용시 에러남
    public User dDefaultUser(){
        return new User("dafault", 0, "010-1111-2222");
    }
}
