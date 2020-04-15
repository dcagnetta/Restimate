package co.za.codeboss.data.elastic.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "session")
public class Session {
    @Id
    private UUID id;
    private String name;
}
