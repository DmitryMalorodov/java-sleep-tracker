package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;

import static ru.yandex.practicum.sleeptracker.helpers.Helper.getSleepSessionsDurations;

public class MinSleepSession extends Base implements Function<List<SleepSession>, SleepAnalysisResult> {
    private static final String FUNC_DESCRIPTION = "Минимальная продолжительность сна (в минутах)";

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        SleepAnalysisResult result = checkSessions(sleepSessions, FUNC_DESCRIPTION);
        if (result != null) return result;

        Duration min = getSleepSessionsDurations(sleepSessions).stream()
                .min(Duration::compareTo)
                .orElseThrow();

        return new SleepAnalysisResult((int) min.toMinutes(), FUNC_DESCRIPTION);
    }
}
