package co.za.codeboss.core.command.impl;

import co.za.codeboss.core.annotations.Command;
import co.za.codeboss.core.command.Dispatcher;
import co.za.codeboss.core.command.HandlersProvider;
import co.za.codeboss.core.command.handler.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommandDispatcher implements Dispatcher {

	private HandlersProvider handlersProvider;

	@Autowired
	public CommandDispatcher(HandlersProvider handlersProvider) {
		this.handlersProvider = handlersProvider;
	}

	/**
	 * Gets the handler for the command type
	 * */
	@Override
	public Object send(Object command){
		if (isAsynchronous(command)){
			//TODO add to the queue. Queue should send this command to the RunEnvironment
			return null;
		}

		CommandHandler<Object, Object> handler = handlersProvider.getHandler(command);
		//You can add Your own capabilities here: dependency injection, security, transaction management, logging, profiling, spying, storing commands, etc
		Object result = handler.handle(command);
		//You can add Your own capabilities here
		return result;
	}

	/**
	 * @param command
	 * @return
	 */
	private boolean isAsynchronous(Object command) {
		if (! command.getClass().isAnnotationPresent(Command.class)) return false;

		Command commandAnnotation = command.getClass().getAnnotation(Command.class);		
		return commandAnnotation.asynchronous();		
	}
}
