package com.example.jpa.hellojpa.repository;

import com.example.jpa.hellojpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
