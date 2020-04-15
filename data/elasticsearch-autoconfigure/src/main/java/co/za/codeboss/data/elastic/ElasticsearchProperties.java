package co.za.codeboss.data.elastic;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "restimate.data.elasticsearch")
public class ElasticsearchProperties {

    private String schema = "https";
    private String host = "test-elastic-cluster-1016506267.eu-west-1.bonsaisearch.net";
    private int port = 443;
    private Account account = new Account();

    @Data
    public static class Account {
        private String username;
        private String password;
    }
}
