package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.helpers.Helper;

import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.function.Function;

public class QuantityNightsWithoutSleep implements Function<List<SleepSession>, SleepAnalysisResult> {
    private static final String FUNC_DESCRIPTION = "Количество бессонных ночей";

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        int allNights = 0;
        if (sleepSessions.getFirst().getAsleepTime().toLocalTime().isBefore(LocalTime.of(12, 0))) {
            allNights++;
        }
        allNights += Period.between(sleepSessions.getFirst().getAsleepTime().toLocalDate(),
                sleepSessions.getLast().getAwakeTime().toLocalDate()).getDays();

        int nightSleepSessions = Helper.getNightSleepQuantity(sleepSessions);

        return new SleepAnalysisResult(allNights - nightSleepSessions, FUNC_DESCRIPTION);
    }
}
