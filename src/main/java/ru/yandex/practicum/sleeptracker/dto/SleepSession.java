package ru.yandex.practicum.sleeptracker.dto;

import ru.yandex.practicum.sleeptracker.enums.SleepQuality;

import java.time.LocalDateTime;

public class SleepSession {
    private final LocalDateTime asleepTime;
    private final LocalDateTime awakeTime;
    private final SleepQuality sleepQuality;

    public SleepSession(LocalDateTime asleepTime, LocalDateTime awakeTime, SleepQuality sleepQuality) {
        this.asleepTime = asleepTime;
        this.awakeTime = awakeTime;
        this.sleepQuality = sleepQuality;
    }

    public LocalDateTime getAsleepTime() {
        return asleepTime;
    }

    public LocalDateTime getAwakeTime() {
        return awakeTime;
    }

    public SleepQuality getSleepQuality() {
        return sleepQuality;
    }
}
