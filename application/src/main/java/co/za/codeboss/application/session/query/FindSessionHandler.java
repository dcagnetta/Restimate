package co.za.codeboss.application.session.query;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.CommandHandler;
import co.za.codeboss.data.elastic.repositories.SessionRepository;
import co.za.codeboss.domain.model.Session;

@CommandHandlerAnnotation
public class FindSessionHandler implements CommandHandler<FindSession, Session> {

    private SessionRepository repository;

    public FindSessionHandler(SessionRepository repository) {
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
