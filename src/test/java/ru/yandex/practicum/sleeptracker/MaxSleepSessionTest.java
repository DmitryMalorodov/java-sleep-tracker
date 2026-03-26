package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.results.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.functions.MaxSleepSession;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Проверка подсчета максимальной продолжительности сна (в минутах)")
public class MaxSleepSessionTest extends TestData {
    private static final List<SleepSession> sleepSessions = new ArrayList<>();
    private static final List<SleepSession> sleepSessions2 = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        sleepSessions.add(sleepSession);
        sleepSessions.add(sleepSession2);
        sleepSessions.add(sleepSession3);

        //добавляем две сессии с одинаково максимальным кол-ом минут
        sleepSessions2.add(sleepSession);
        sleepSessions2.add(sleepSession2);
        sleepSessions2.add(sleepSession3);
        sleepSessions2.add(sleepSession5);
    }

    @Test
    @DisplayName("Проверка подсчета максимальной продолжительности сна (в минутах)")
    public void check() {
        SleepAnalysisResult result = new MaxSleepSession().apply(sleepSessions);
        GeneralAssertions.isEqualTo(600, result.getResult(),
                "Ожидаемая максимальная продолжительность сна '%d' не соответствует фактической '%d'");
    }

    @Test
    @DisplayName("Проверка подсчета максимальной продолжительности сна (в минутах)")
    public void check2() {
        SleepAnalysisResult result = new MaxSleepSession().apply(sleepSessions2);
        GeneralAssertions.isEqualTo(600, result.getResult(),
                "Ожидаемая максимальная продолжительность сна '%d' не соответствует фактической '%d'");
    }
}
