package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;

import java.util.List;

public class Base {
    static final String NO_SESSION_MESSAGE = "Нет ни одной сессии сна для расчета";

    static SleepAnalysisResult checkSessions(List<SleepSession> sleepSessions, String description) {
        return sleepSessions.isEmpty()
                ? new SleepAnalysisResult(NO_SESSION_MESSAGE, description)
                : null;
    }
}
