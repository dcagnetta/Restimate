package co.za.codeboss.setup;

import co.za.codeboss.annotations.CommandHandlerAnnotation;
import co.za.codeboss.command.handler.CommandHandler;

@CommandHandlerAnnotation
public class TestCommandHandler  implements CommandHandler<TestCommand, String> {

    @Override
    public String handle(TestCommand testCommand) {
        return testCommand.getName();
    }

}
