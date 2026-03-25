package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.results.Result;
import ru.yandex.practicum.sleeptracker.dto.results.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;

import java.util.List;
import java.util.function.Function;

public class QuantitySleepSessions implements Function<List<SleepSession>, Result> {

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSession) {
        return new SleepAnalysisResult(sleepSession.size(), "Количество сессий сна всего");
    }
}
