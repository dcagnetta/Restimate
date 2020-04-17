package co.za.codeboss.data.elastic.repositories;

import co.za.codeboss.documents.SessionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;
import java.util.concurrent.Future;
/**
 * https://stackoverflow.com/questions/46548804/spring-data-jpa-return-future
 * */
public interface ISessionElasticsearchRepository extends ElasticsearchRepository<SessionDocument, UUID> {
    @Async
    Future<Iterable<SessionDocument>> findByName(String name);

    @Async
    Future<SessionDocument> findOneById(UUID id);
}
