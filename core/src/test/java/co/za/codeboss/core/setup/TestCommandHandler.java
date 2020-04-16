package co.za.codeboss.core.setup;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@CommandHandlerAnnotation
public class TestCommandHandler  implements ICommandHandler<TestCommand, String> {

    @Override
    public Future<String> handle(TestCommand testCommand) {
        return CompletableFuture.completedFuture(testCommand.getName());
    }

}
