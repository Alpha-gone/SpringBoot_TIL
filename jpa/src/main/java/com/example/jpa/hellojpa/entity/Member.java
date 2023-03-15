package com.example.jpa.hellojpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name")
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


}
