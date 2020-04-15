package co.za.codeboss.data.elastic.documents;

import lombok.Data;

import java.util.UUID;

@Data
public class EstimatorNestedDocument {
    private UUID id;
    private String name;
}
