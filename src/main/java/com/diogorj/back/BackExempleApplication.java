package com.diogorj.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackExempleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackExempleApplication.class, args);
	}

}
