package io.justinthelaw.portfolio;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PortfolioApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8080")); //TODO: implement env variables
        app.run(args);
	}

}
