package co.za.codeboss.application.session.command.join;

import co.za.codeboss.core.annotations.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Command
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoinSession {
    private UUID sessionId;
    private String estimatorName;
}
