package co.za.codeboss.application.session.createsession;

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
public class CreateSession {
    private UUID id;
    private String name;
    private String shortId;
}
