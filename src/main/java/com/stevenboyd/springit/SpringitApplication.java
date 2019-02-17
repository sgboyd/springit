package com.stevenboyd.springit;

import com.stevenboyd.springit.domain.Comment;
import com.stevenboyd.springit.domain.Link;
import com.stevenboyd.springit.repository.CommentRepository;
import com.stevenboyd.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

	//@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
		return args -> {
			Link link = new Link("Getting started with Spring Boot 2", "https://therealdanvega.com/spring-boot-2");
			linkRepository.save(link);

			Comment comment = new Comment("This Spring Boot 2 link is awesome", link);
			commentRepository.save(comment);

			link.addComment(comment);

			Link firstLink = linkRepository.findByTitle("Getting started with Spring Boot 2");
			System.out.println(firstLink.getTitle());
		};
	}

}

