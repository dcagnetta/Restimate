package co.za.codeboss.repositories;

import java.util.UUID;
import java.util.concurrent.Future;

public interface IGenericDbRepository<TDocument> {
    Future<Iterable<TDocument>> findByName(String name);
    Future<TDocument> findOneById(UUID id);
    //<S extends TDocument> Future<S> save(TDocument document);
}
