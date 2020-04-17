package co.za.codeboss.documents;

import lombok.Data;

import java.util.UUID;

@Data
public class EstimatorNestedDocument {
    private UUID id;
    private String name;

    public static EstimatorNestedDocument create(String name) {
        var estimator =  new EstimatorNestedDocument();
        estimator.setId(UUID.randomUUID());
        estimator.setName(name);
        return estimator;
    }
}
