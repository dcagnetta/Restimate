package co.za.codeboss.application.session.create;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.documents.SessionDocument;
import co.za.codeboss.data.elastic.repositories.ISessionRepository;

import java.util.UUID;

@CommandHandlerAnnotation
public class CreateSessionHandler implements ICommandHandler<CreateSession, Void>, ICreateSessionUseCase {

    private ISessionRepository repository;

    public CreateSessionHandler(ISessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void handle(CreateSession createSession) {
        var session = SessionDocument.builder().id(UUID.randomUUID()).name("Test Session").build();
        repository.save(session);
        return null;
    }

}
