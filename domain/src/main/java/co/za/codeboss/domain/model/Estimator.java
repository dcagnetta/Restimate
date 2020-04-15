package co.za.codeboss.domain.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Estimator {
    private UUID id;
    private String name;
}
