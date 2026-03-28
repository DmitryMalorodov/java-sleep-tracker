package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.enums.SleepQuality;

import java.util.List;
import java.util.function.Function;

public class QuantityBadSleepSession extends Base implements Function<List<SleepSession>, SleepAnalysisResult> {
    private static final String FUNC_DESCRIPTION = "Количество сессий с плохим качеством сна";

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        SleepAnalysisResult result = checkSessions(sleepSessions, FUNC_DESCRIPTION);
        if (result != null) return result;

        List<SleepSession> sessions = sleepSessions.stream()
                .filter(session -> session.getSleepQuality().equals(SleepQuality.BAD))
                .toList();

        return new SleepAnalysisResult(sessions.size(), FUNC_DESCRIPTION);
    }
}
