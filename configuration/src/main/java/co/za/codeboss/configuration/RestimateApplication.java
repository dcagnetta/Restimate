package co.za.codeboss.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCodeBossModules
@SpringBootApplication
public class RestimateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestimateApplication.class, args);
    }

}
