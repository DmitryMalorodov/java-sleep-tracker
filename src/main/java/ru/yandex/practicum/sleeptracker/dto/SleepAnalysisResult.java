package ru.yandex.practicum.sleeptracker.dto;

public class SleepAnalysisResult {
    private final String description;
    private final Object result;

    public SleepAnalysisResult(Object result, String description) {
        this.description = description;
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public Object getResult() {
        return result;
    }
}
