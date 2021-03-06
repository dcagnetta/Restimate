package co.za.codeboss.documents;

import lombok.Data;

import java.util.UUID;

@Data
public class EstimateNestedDocument {
    private UUID id;

    private int confidence;
    private int timeStart;
    private int timeEnd;
    private String timePeriod;
}
