package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;

import java.util.List;
import java.util.function.Function;

import static ru.yandex.practicum.sleeptracker.helpers.Helper.getSleepSessionsDurations;

public class AverageSleepSession implements Function<List<SleepSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        int sum = getSleepSessionsDurations(sleepSessions).stream()
                .mapToInt(duration -> (int) duration.toMinutes())
                .sum();

        return new SleepAnalysisResult(sum / sleepSessions.size(), "Средняя продолжительность сна (в минутах)");
    }
}
