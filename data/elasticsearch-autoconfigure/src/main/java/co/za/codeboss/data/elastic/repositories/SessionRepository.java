package co.za.codeboss.data.elastic.repositories;

import co.za.codeboss.data.elastic.documents.Session;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface  SessionRepository extends ElasticsearchRepository<Session, UUID> {
    List<Session> findByName(String name);
}
