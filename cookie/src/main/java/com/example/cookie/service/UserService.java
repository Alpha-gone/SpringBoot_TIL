package com.example.cookie.service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public String login(LoginRequest request, HttpServletResponse response){
        var id = request.getId();
        var password = request.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()){
            var userDto = optionalUser.get();

            if (userDto.getPassword().equals(password)){
//                var cookie = new Cookie("authorization-cookie", userDto.getId());
//                cookie.setDomain("localhost");
//                cookie.setHttpOnly(true);
////                cookie.setSecure(true); << https에서만 사용되도록 설정
//                cookie.setPath("/");
//                cookie.setMaxAge(-1); //session과 동일
//
//                response.addCookie(cookie);

                return userDto.getId();
            }

        }else{
            throw new RuntimeException("User Not Found");
        }

        return null;
    }
}
