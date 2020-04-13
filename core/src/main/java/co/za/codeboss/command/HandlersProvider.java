package co.za.codeboss.command;

import co.za.codeboss.command.handler.CommandHandler;

/**
 * Returns the required handler based on the command
 */
public interface HandlersProvider {
    CommandHandler<Object, Object> getHandler(Object command);
}
