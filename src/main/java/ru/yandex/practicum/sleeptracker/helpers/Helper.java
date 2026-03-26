package ru.yandex.practicum.sleeptracker.helpers;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private static final LocalTime sixAm = LocalTime.of(6, 0);
    private static final LocalTime midnight = LocalTime.MIDNIGHT;

    private Helper() {
    }

    public static List<Duration> getSleepSessionsDurations(List<SleepSession> sleepSessions) {
        List<Duration> durations = new ArrayList<>();

        sleepSessions.forEach(session ->
                durations.add(Duration.between(session.getAsleepTime(), session.getAwakeTime())));

        return durations;
    }

    public static List<SleepSession> getNightSleepSessions(List<SleepSession> sleepSessions) {
        List<SleepSession> nightSleepSessions = new ArrayList<>();

        sleepSessions.forEach(session -> {
            if (session.getAsleepTime().getDayOfMonth() != session.getAwakeTime().getDayOfMonth()) {
                nightSleepSessions.add(session);
            } else if (!session.getAsleepTime().toLocalTime().isBefore(midnight)
                    && !session.getAsleepTime().toLocalTime().isAfter(sixAm)) {
                nightSleepSessions.add(session);
            } else if (!session.getAwakeTime().toLocalTime().isBefore(midnight)
                    && !session.getAwakeTime().toLocalTime().isAfter(sixAm)) {
                nightSleepSessions.add(session);
            }
        });

        return nightSleepSessions;
    }
}
