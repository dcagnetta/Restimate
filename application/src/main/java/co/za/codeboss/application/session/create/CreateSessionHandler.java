package co.za.codeboss.application.session.create;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.CommandHandler;

@CommandHandlerAnnotation
public class CreateSessionHandler implements CommandHandler<CreateSession, Void>, ICreateSessionHandler {

    @Override
    public Void handle(CreateSession createSession) {
        return null;
    }

}
