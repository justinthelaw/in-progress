package io.justinthelaw.portfolio;

import java.util.Collections;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

  public static void main(String[] args) {

    Dotenv env = Dotenv.configure()
        .ignoreIfMalformed()
        .ignoreIfMissing()
        .load();
    String port = env.get("SERVER_PORT");

    SpringApplication app = new SpringApplication(PortfolioApplication.class);
    app.setDefaultProperties(Collections
        .singletonMap("server.port", port));
    app.run(args);
  }

}
