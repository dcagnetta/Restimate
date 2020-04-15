package co.za.codeboss.data.elastic.repositories;

import co.za.codeboss.data.elastic.documents.SessionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface ISessionRepository extends ElasticsearchRepository<SessionDocument, UUID> {
    List<SessionDocument> findByName(String name);
}
