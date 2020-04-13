package co.za.codeboss.core.setup;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.CommandHandler;

@CommandHandlerAnnotation
public class TestCommandHandler  implements CommandHandler<TestCommand, String> {

    @Override
    public String handle(TestCommand testCommand) {
        return testCommand.getName();
    }

}
