package com.example.jpa.hellojpa.entity;

import com.example.jpa.hellojpa.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamTest {

    @Autowired
    private TeamRepository repository;

    @Test
    public void runTest(){
        Team team = new Team();
        team.setName("test");

        repository.save(team);
    }
}