package com.conchu.hbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(HbdApplication.class, args);
	}

}
