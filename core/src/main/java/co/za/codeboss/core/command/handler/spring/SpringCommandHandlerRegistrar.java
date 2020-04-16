package co.za.codeboss.core.command.handler.spring;

import co.za.codeboss.core.command.handler.ICommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
@Component
public class SpringCommandHandlerRegistrar {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Autowired
    private CommandHandlersMap handlers;

    @Async
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() throws InterruptedException {
        String[] commandHandlersNames = beanFactory.getBeanNamesForType(ICommandHandler.class);
        for (String beanName : commandHandlersNames) {
            BeanDefinition commandHandler = beanFactory.getBeanDefinition(beanName);
            try {
                Class<?> handlerClass = Class.forName(commandHandler.getBeanClassName());
                handlers.put(getHandledCommandType(handlerClass), beanName);
                log.info("\t *** Detected ICommandHandler: {}", beanName );
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Returns e.g.
     *
     *  TestCommand from CommandHandler<TestCommand, Void>
     **/
    private Class<?> getHandledCommandType(Class<?> clazz) {
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        ParameterizedType type = findByRawType(genericInterfaces, ICommandHandler.class);
        return (Class<?>) type.getActualTypeArguments()[0]; // the TCommand
    }

    /**
     * Returns e.g.
     *
     *   <p> CommandHandler<TestCommand, Void> </p>
     *
     *   which is the raw type i.e. implemented interface
     **/
    private ParameterizedType findByRawType(Type[] genericInterfaces, Class<?> expectedRawType) {
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) { // GenericType in C#
                ParameterizedType parametrized = (ParameterizedType) type;
                if (expectedRawType.equals(parametrized.getRawType())) {
                    return parametrized;
                }
            }
        }
        throw new RuntimeException();
    }

}
