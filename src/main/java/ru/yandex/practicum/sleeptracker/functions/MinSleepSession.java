package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;

import static ru.yandex.practicum.sleeptracker.helpers.Helper.getSleepSessionsDurations;

public class MinSleepSession implements Function<List<SleepSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        Duration min = getSleepSessionsDurations(sleepSessions).stream()
                .min(Duration::compareTo)
                .orElseThrow();

        return new SleepAnalysisResult((int) min.toMinutes(), "Минимальная продолжительность сна (в минутах)");
    }
}
