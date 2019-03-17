package com.ninox.ninoxerp.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ninox.ninoxerp")
@EntityScan("com.ninox.ninoxerp.core")
@SpringBootApplication
public class NinoxerpApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinoxerpApplication.class, args);
	}
}
