package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public UserEntity findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public List<UserEntity> findAll() {
            return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public List<UserEntity> filterScore(int score){
        return userRepository.findAllGreaterThen(score);
    }
}
