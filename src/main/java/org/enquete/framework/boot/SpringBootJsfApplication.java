package org.enquete.framework.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("org.enquete")
@EnableJpaRepositories("org.enquete")
@PropertySource(value = "classpath:application.properties")
public class SpringBootJsfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJsfApplication.class, args);
	}
	
}
