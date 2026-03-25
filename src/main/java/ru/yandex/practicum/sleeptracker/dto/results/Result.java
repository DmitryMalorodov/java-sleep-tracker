package ru.yandex.practicum.sleeptracker.dto.results;

public abstract class Result {
    private final String description;

    public Result(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract <T> T getResult();
}
