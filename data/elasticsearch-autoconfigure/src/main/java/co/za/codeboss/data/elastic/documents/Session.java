package co.za.codeboss.data.elastic.documents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@NoArgsConstructor
@Getter @Setter
@Document(indexName = "session")
public class Session {
    @Id
    private UUID id;
    private String name;
}
