package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.results.Result;
import ru.yandex.practicum.sleeptracker.dto.results.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.enums.SleepQuality;

import java.util.List;
import java.util.function.Function;

public class QuantityBadSleepSession implements Function<List<SleepSession>, Result> {

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        List<SleepSession> sessions = sleepSessions.stream()
                .filter(session -> session.getSleepQuality().equals(SleepQuality.BAD))
                .toList();

        return new SleepAnalysisResult(sessions.size(), "Количество сессий с плохим качеством сна");
    }
}
