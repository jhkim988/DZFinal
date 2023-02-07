package com.douzone.dzfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DzfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DzfinalApplication.class, args);
	}

}
