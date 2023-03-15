package com.example.jpa.hellojpa.repository;

import com.example.jpa.hellojpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
