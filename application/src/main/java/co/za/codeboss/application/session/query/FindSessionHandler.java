package co.za.codeboss.application.session.query;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.repositories.ISessionRepository;
import co.za.codeboss.domain.model.Session;

@CommandHandlerAnnotation
public class FindSessionHandler implements ICommandHandler<FindSession, Session> {

    private ISessionRepository repository;

    public FindSessionHandler(ISessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Session handle(FindSession query) {
        var document =  repository.findById(query.getId()).get();

        // map to domain
        var session = Session.create(document.getId(), document.getName());

        return session;
    }

}
