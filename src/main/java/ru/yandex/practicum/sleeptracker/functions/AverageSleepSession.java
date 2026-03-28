package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;

import java.util.List;
import java.util.function.Function;

import static ru.yandex.practicum.sleeptracker.helpers.Helper.getSleepSessionsDurations;

public class AverageSleepSession extends Base implements Function<List<SleepSession>, SleepAnalysisResult> {
    private static final String FUNC_DESCRIPTION = "Средняя продолжительность сна (в минутах)";

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        SleepAnalysisResult result = checkSessions(sleepSessions, FUNC_DESCRIPTION);
        if (result != null) return result;

        int sum = getSleepSessionsDurations(sleepSessions).stream()
                .mapToInt(duration -> (int) duration.toMinutes())
                .sum();

        return new SleepAnalysisResult(sum / sleepSessions.size(), FUNC_DESCRIPTION);
    }
}
