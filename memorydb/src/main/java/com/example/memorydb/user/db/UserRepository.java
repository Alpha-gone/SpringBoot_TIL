package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //select * from user where score >= []
    List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    //select * from user where socre>= ?? and socre <=??
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    @Query(value = "select * from user as u where u.score >= :min and u.score <= :max", nativeQuery = true)
    List<UserEntity> score(@Param("min") int min,
                           @Param("max") int max);
}
