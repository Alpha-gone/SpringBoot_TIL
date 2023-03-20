package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {
    public List<UserEntity> findAllGreaterThen(int score){
        return this.findAll().stream().filter(userEntity -> userEntity.getScore() >= score).toList();
    }
}
