package pl.coderslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TwitterApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}
}
