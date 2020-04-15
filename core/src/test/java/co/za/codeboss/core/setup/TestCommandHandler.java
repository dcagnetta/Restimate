package co.za.codeboss.core.setup;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;

@CommandHandlerAnnotation
public class TestCommandHandler  implements ICommandHandler<TestCommand, String> {

    @Override
    public String handle(TestCommand testCommand) {
        return testCommand.getName();
    }

}
