package co.za.codeboss.core.command.handler.spring;


import co.za.codeboss.core.command.IHandlersProvider;
import co.za.codeboss.core.command.handler.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Registers handlers for Spring and provides the required handler when needed
 * https://stackoverflow.com/questions/47915493/spring-5-programmatically-register-generic-bean
 */
@Component
public class SpringHandlersProvider implements IHandlersProvider {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Autowired
    private CommandHandlersMap handlers;

    @SuppressWarnings("unchecked")
	@Override
    public ICommandHandler<Object, Object> getHandler(Object command) {
        String beanName = handlers.get(command.getClass());
        if (beanName == null) {
            throw new RuntimeException("command handler not found. Command class is " + command.getClass());
        }
        ICommandHandler<Object, Object> handler = beanFactory.getBean(beanName, ICommandHandler.class);
        return handler;
    }
}
