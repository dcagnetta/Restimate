package co.za.codeboss.documents;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class EstimationItemNestedDocument {
    private UUID id;

    private String name;
    private String description;

    Set<EstimateNestedDocument> estimates;
}
