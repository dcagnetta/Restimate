package co.za.codeboss.application.session.query;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.documents.SessionDocument;
import co.za.codeboss.data.elastic.repositories.ISessionElasticsearchRepository;
import co.za.codeboss.domain.model.Session;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@CommandHandlerAnnotation
public class FindSessionHandler implements ICommandHandler<FindSession, Session> {

    private ISessionElasticsearchRepository repository;

    public FindSessionHandler(ISessionElasticsearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Future<Session> handle(FindSession query) throws Exception {
        Future<SessionDocument> future = repository.findOneById(query.getSessionId());
        var document =  future.get();

        // map to domain
        var session = Session.create(document.getId(), document.getName());

        return CompletableFuture.completedFuture(session);
    }

}
