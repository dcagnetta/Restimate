package co.za.codeboss.data.elastic;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "restimate.data.elasticsearch")
public class ElasticsearchProperties {

    private String schema;
    private String host;
    private int port;
    private Account account = new Account();

    @Data
    public static class Account {
        private String username;
        private String password;
    }
}
