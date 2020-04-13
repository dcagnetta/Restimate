package co.za.codeboss.core.command;

import co.za.codeboss.core.command.handler.CommandHandler;

/**
 * Returns the required handler based on the command
 */
public interface HandlersProvider {
    CommandHandler<Object, Object> getHandler(Object command);
}
