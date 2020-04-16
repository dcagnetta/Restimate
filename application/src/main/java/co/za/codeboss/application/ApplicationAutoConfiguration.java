package co.za.codeboss.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan
/*
 * Interface ISSUE: https://github.com/spring-projects/spring-framework/issues/18120#issuecomment-453431172
 * */
@EnableAsync(proxyTargetClass=true)
public class ApplicationAutoConfiguration {
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("asyncThread-");
        executor.initialize();
        return executor;
    }
}
