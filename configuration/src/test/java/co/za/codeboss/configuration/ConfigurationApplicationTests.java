package co.za.codeboss.configuration;

import co.za.codeboss.core.command.handler.spring.CommandHandlersMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConfigurationApplicationTests {

    @Autowired
    private CommandHandlersMap handlers;

    @Test
    void contextLoads() {
        assertThat(handlers).isNotNull();
    }

}
