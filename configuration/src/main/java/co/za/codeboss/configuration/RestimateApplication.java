package co.za.codeboss.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"co.za.codeboss.core", "co.za.codeboss.web", "co.za.codeboss.application"})
@SpringBootApplication
public class RestimateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestimateApplication.class, args);
    }

}
