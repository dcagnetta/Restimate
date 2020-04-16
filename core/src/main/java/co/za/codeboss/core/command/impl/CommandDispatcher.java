package co.za.codeboss.core.command.impl;

import co.za.codeboss.core.annotations.Command;
import co.za.codeboss.core.command.Dispatcher;
import co.za.codeboss.core.command.IHandlersProvider;
import co.za.codeboss.core.command.handler.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;


@Component
public class CommandDispatcher implements Dispatcher {

	private IHandlersProvider handlersProvider;

	@Autowired
	public CommandDispatcher(IHandlersProvider handlersProvider) {
		this.handlersProvider = handlersProvider;
	}

	/**
	 * Gets the handler for the command type
	 * */
	@Override
	public Future<Object> send(Object command){
		if (isAsynchronous(command)){
			//TODO add to the queue. Queue should send this command to the RunEnvironment
			return null;
		}

		ICommandHandler<Object, Object> handler = handlersProvider.getHandler(command);
		//You can add Your own capabilities here: dependency injection, security, transaction management, logging, profiling, spying, storing commands, etc
		Future<Object> future = handler.handle(command);
		//You can add Your own capabilities here
		return future;
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
