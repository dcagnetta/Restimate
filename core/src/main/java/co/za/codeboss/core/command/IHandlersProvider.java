package co.za.codeboss.core.command;

import co.za.codeboss.core.command.handler.ICommandHandler;

/**
 * Returns the required handler based on the command
 */
public interface IHandlersProvider {
    ICommandHandler<Object, Object> getHandler(Object command);
}
