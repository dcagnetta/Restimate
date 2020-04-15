package co.za.codeboss.data.elastic;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@EnableConfigurationProperties(ElasticsearchProperties.class)
@EnableElasticsearchRepositories(basePackages = "co.za.codeboss.data.elastic.repositories")
public class ElasticsearchAutoConfiguration {

    private final ElasticsearchProperties settings;

    @Bean
    @ConditionalOnMissingBean
    public RestHighLevelClient elasticsearchClient() {
        var host = settings.getHost();
        var port = settings.getPort();
        var username = settings.getAccount().getUsername();
        var password = settings.getAccount().getPassword();

        final var clientConfiguration = ClientConfiguration.builder()
                .connectedTo(host + ":" + port)
                .withBasicAuth(username, password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

}
