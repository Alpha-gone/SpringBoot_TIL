package com.example.cookie.controller;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private final UserRepository repository;

    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest request,
            @CookieValue(name = "authorization-cookie", required = false) String authorizationCookie){
        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUserDto = repository.findById(authorizationCookie);

        return optionalUserDto.get();

//        var cookies = request.getCookies();
//
//        if (cookies != null){
//            for (Cookie cookie : cookies){
//                log.info("Key : {}, value : {}", cookie.getName(), cookie.getValue());
//            }
//        }

//        return null;
    }

    @GetMapping("/me2")
    public UserDto me2(
            @RequestHeader(name ="authorization", required = false) String authorizationHeader){
        log.info("authorizationHeader : {}", authorizationHeader);

        var optionalUserDto = repository.findById(authorizationHeader);

        return optionalUserDto.get();

    }
}
