package com.example.validation.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {
    @NotBlank
    private String name;

    @Min(value = 0)
    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;
}
