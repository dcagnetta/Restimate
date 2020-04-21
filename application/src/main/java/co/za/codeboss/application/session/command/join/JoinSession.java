package co.za.codeboss.application.session.command.join;

import co.za.codeboss.core.annotations.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Command
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoinSession {
    private String shortId;
    private String username;
}
