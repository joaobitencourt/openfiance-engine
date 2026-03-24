package com.john.openfinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OpenfinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfinanceApplication.class, args);
	}

}
