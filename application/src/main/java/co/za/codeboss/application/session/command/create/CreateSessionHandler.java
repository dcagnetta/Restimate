package co.za.codeboss.application.session.command.create;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.documents.SessionDocument;
import co.za.codeboss.data.elastic.repositories.ISessionElasticsearchRepository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@CommandHandlerAnnotation
public class CreateSessionHandler implements ICommandHandler<CreateSession, Void>, ICreateSessionUseCase {

    private ISessionElasticsearchRepository repository;

    public CreateSessionHandler(ISessionElasticsearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Future<Void> handle(CreateSession command) {
        var session = SessionDocument.builder()
                .id(command.getId())
                .name(command.getName())
                .build();

        repository.save(session);
        return  CompletableFuture.completedFuture(null);
    }

}
