package co.za.codeboss;

import co.za.codeboss.command.HandlersProvider;
import co.za.codeboss.command.impl.CommandDispatcher;
import co.za.codeboss.setup.TestCommand;
import co.za.codeboss.setup.TestCommandHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CommandHandlerTests {

    @Test
    public void should_send_test_command() {
        var command = new TestCommand("testing the command");
        var handler = new TestCommandHandler();

        var handlersProviderMock = Mockito.mock(HandlersProvider.class);
        Mockito.doReturn(handler).when(handlersProviderMock).getHandler(command);
        // Error happening cause compiler can not guarantee that returned type
        // Mockito.when(handlersProviderMock.getHandler(command)).thenReturn( );

        var dispatcher = new CommandDispatcher(handlersProviderMock);

        var result = dispatcher.send(command);

        assertEquals(result, "testing the command");
    }

}