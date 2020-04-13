package co.za.codeboss.configuration;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = {"co.za.codeboss.core", "co.za.codeboss.web", "co.za.codeboss.application"})
public @interface EnableCodeBossModules {
}
