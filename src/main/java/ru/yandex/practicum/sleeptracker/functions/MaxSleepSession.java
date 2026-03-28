package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static ru.yandex.practicum.sleeptracker.helpers.Helper.getSleepSessionsDurations;

public class MaxSleepSession extends Base implements Function<List<SleepSession>, SleepAnalysisResult> {
    private static final String FUNC_DESCRIPTION = "Максимальная продолжительность сна (в минутах)";

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        SleepAnalysisResult result = checkSessions(sleepSessions, FUNC_DESCRIPTION);
        if (result != null) return result;

        Duration max = getSleepSessionsDurations(sleepSessions).stream()
                .max(Duration::compareTo)
                .orElseThrow();

        return new SleepAnalysisResult((int) max.toMinutes(), FUNC_DESCRIPTION);
    }
}
