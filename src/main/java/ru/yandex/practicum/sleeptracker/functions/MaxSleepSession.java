package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static ru.yandex.practicum.sleeptracker.helpers.Helper.getSleepSessionsDurations;

public class MaxSleepSession implements Function<List<SleepSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        Duration max = getSleepSessionsDurations(sleepSessions).stream()
                .max(Duration::compareTo)
                .orElseThrow();

        return new SleepAnalysisResult((int) max.toMinutes(), "Максимальная продолжительность сна (в минутах)");
    }
}
