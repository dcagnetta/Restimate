package co.za.codeboss.core;

import co.za.codeboss.core.command.IHandlersProvider;
import co.za.codeboss.core.command.impl.CommandDispatcher;
import co.za.codeboss.core.setup.TestCommand;
import co.za.codeboss.core.setup.TestCommandHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandHandlerTests {

    @Test
    public void should_send_test_command() throws Exception {
        var command = new TestCommand("testing the command");
        var handler = new TestCommandHandler();

        var handlersProviderMock = setupHandlersProvider(command, handler);

        var dispatcher = new CommandDispatcher(handlersProviderMock);

        var future = dispatcher.send(command);

        assertEquals(future.get(), "testing the command");
    }

    private IHandlersProvider setupHandlersProvider(TestCommand command, TestCommandHandler handler) {
        var handlersProviderMock = Mockito.mock(IHandlersProvider.class);
        Mockito.doReturn(handler).when(handlersProviderMock).getHandler(command);
        // Error happening cause compiler can not guarantee that returned type
        // Mockito.when(handlersProviderMock.getHandler(command)).thenReturn( );
        return handlersProviderMock;
    }
}