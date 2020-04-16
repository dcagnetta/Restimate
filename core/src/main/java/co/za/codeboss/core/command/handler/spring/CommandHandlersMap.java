package co.za.codeboss.core.command.handler.spring;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CommandHandlersMap extends HashMap<Class<?>, String> {}
