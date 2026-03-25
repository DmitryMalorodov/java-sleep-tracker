package ru.yandex.practicum.sleeptracker.dto.results;

public class SleepAnalysisResult extends Result {
    private final Integer result;

    public SleepAnalysisResult(Integer result, String description) {
        super(description);
        this.result = result;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
