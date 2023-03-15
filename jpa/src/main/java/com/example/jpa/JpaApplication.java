package com.example.jpa;

import com.example.jpa.hellojpa.Main;
import com.example.jpa.hellojpa.entity.Member;
import com.example.jpa.hellojpa.entity.Team;
import com.example.jpa.hellojpa.provider.ApplicationContextProvider;
import com.example.jpa.hellojpa.repository.MemberRepository;
import com.example.jpa.hellojpa.repository.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@EnableJpaRepositories
@SpringBootApplication
public class JpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);

		ApplicationContext context = ApplicationContextProvider.getContext();
		Main main = context.getBean(Main.class);

		main.run();

	}

}
