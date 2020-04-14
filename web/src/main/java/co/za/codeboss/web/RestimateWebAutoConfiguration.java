package co.za.codeboss.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // without "basePackages" will start scanning at this package
public class RestimateWebAutoConfiguration {
}
