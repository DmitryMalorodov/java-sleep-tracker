package ru.yandex.practicum.sleeptracker.helpers;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    private Helper() {
    }

    public static List<Duration> getSleepSessionsDurations(List<SleepSession> sleepSessions) {
        List<Duration> durations = new ArrayList<>();

        sleepSessions.forEach(session ->
                durations.add(Duration.between(session.getAsleepTime(), session.getAwakeTime())));

        return durations;
    }
}
