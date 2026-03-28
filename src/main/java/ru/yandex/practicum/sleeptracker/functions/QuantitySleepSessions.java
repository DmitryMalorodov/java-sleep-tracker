package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;

import java.util.List;
import java.util.function.Function;

public class QuantitySleepSessions extends Base implements Function<List<SleepSession>, SleepAnalysisResult> {
    private static final String FUNC_DESCRIPTION = "Количество сессий сна всего";

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSession) {
        SleepAnalysisResult result = checkSessions(sleepSession, FUNC_DESCRIPTION);
        if (result != null) return result;

        return new SleepAnalysisResult(sleepSession.size(), FUNC_DESCRIPTION);
    }
}
