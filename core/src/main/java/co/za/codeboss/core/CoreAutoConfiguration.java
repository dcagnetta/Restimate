package co.za.codeboss.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan
@EnableAsync(proxyTargetClass=true)
public class CoreAutoConfiguration {
}
