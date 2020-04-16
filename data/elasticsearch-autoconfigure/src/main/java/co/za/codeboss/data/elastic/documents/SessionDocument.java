package co.za.codeboss.data.elastic.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "session")
public class SessionDocument {
    @Id
    private UUID id;
    private String name;
    private String shortId;

    private Set<EstimatorNestedDocument> estimators;
    private Set<EstimationItemNestedDocument> items;
}
