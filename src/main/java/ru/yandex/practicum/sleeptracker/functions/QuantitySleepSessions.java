package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;

import java.util.List;
import java.util.function.Function;

public class QuantitySleepSessions implements Function<List<SleepSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSession) {
        return new SleepAnalysisResult(sleepSession.size(), "Количество сессий сна всего");
    }
}
