package com.projeto04.Av1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Av1Application {

	public static void main(String[] args) {
		SpringApplication.run(Av1Application.class, args);
	}

}
