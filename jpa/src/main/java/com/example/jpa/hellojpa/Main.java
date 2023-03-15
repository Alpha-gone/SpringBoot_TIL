package com.example.jpa.hellojpa;

import com.example.jpa.hellojpa.entity.Member;
import com.example.jpa.hellojpa.entity.Team;
import com.example.jpa.hellojpa.repository.MemberRepository;
import com.example.jpa.hellojpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Main {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public void run(){
        Team team = new Team();
        team.setName("teamA");
        teamRepository.save(team);

        Member member = new Member();
        member.setName("hello");
        team.getMembers().add(member);
        member.setTeam(team);
        memberRepository.save(member);


        /*Optional<Member> findMember = memberRepository.findById(member.getId());
        Member getMember = findMember.get();
        Team findTeam = getMember.getTeam();

        findTeam.getMembers().forEach(System.out::println);*/
    }
}
