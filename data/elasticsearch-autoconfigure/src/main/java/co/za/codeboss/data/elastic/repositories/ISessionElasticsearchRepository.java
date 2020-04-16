package co.za.codeboss.data.elastic.repositories;

import co.za.codeboss.data.elastic.documents.SessionDocument;
import co.za.codeboss.repositories.ISessionDbRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;
import java.util.concurrent.Future;

public interface ISessionElasticsearchRepository extends
        ElasticsearchRepository<SessionDocument, UUID>,
        ISessionDbRepository<SessionDocument> {
    @Async
    Future<Iterable<SessionDocument>> findByName(String name);

    @Async
    Future<SessionDocument> findOneById(UUID id);
}
