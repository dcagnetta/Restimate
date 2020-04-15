package co.za.codeboss.application.session.command.create;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.documents.SessionDocument;
import co.za.codeboss.data.elastic.repositories.ISessionRepository;

@CommandHandlerAnnotation
public class CreateSessionHandler implements ICommandHandler<CreateSession, Void>, ICreateSessionUseCase {

    private ISessionRepository repository;

    public CreateSessionHandler(ISessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void handle(CreateSession command) {
        var session = SessionDocument.builder()
                .id(command.getId())
                .name(command.getName())
                .build();

        repository.save(session);
        return null;
    }

}
