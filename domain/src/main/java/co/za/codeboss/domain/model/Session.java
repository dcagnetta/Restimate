package co.za.codeboss.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Session {

    /**
     * The unique ID of the session.
     */
    @Getter
    private UUID id;

    @Getter
    private String name;

    /**
     * Creates an {@link Session} entity with an ID. Use to reconstitute a persisted entity.
     */
    public static Session create(UUID sessionId, String name) {
        return new Session(sessionId, name);
    }
}
