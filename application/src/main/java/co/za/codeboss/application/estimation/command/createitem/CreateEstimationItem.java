package co.za.codeboss.application.estimation.command.createitem;

import co.za.codeboss.core.annotations.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Command
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstimationItem {
    private Long sessionId;
    private String name;
    private String description;
}
