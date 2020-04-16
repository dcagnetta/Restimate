package co.za.codeboss.core.command.handler;

import co.za.codeboss.core.annotations.Command;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

/**
 * @param <TCommand> command
 * @param <TResult>  result type - for asynchronous {@link Command}commands (asynchronous=true) should be {@link Void}
 * @author Dillan
 */
public interface ICommandHandler<TCommand, TResult> {
    @Async        //  Annotations Specifying an Executor Must Be On the Interface
    Future<TResult> handle(TCommand command);
}
