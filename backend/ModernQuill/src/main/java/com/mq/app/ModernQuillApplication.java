package com.mq.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.mq") 
@EntityScan("com.mq.entities") 
@EnableJpaRepositories("com.mq.repositories")
public class ModernQuillApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModernQuillApplication.class, args);
	}

}
