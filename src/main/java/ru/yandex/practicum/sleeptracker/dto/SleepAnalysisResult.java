package ru.yandex.practicum.sleeptracker.dto;

public class SleepAnalysisResult {
    private final Integer result;
    private final String description;

    public SleepAnalysisResult(Integer result, String description) {
        this.result = result;
        this.description = description;
    }

    public Integer getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }
}
