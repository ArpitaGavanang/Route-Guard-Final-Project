package com.RouteGaurd.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class RouteGaurd40Application {

	public static void main(String[] args) {
		SpringApplication.run(RouteGaurd40Application.class, args);
		Dotenv dotenv = Dotenv.load();
        String sendgridApiKey = dotenv.get("SENDGRID_API_KEY");
        System.out.println("SendGrid API Key: " + sendgridApiKey);
	}

}
