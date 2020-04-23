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

    public static EstimationItemNestedDocument create(String name, String description) {
        var item =  new EstimationItemNestedDocument();
        item.setId(UUID.randomUUID());
        item.setName(name);
        item.setDescription(description);
        return item;
    }
}
