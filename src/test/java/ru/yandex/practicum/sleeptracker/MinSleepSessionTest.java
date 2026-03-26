package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.results.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.functions.MinSleepSession;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Проверка подсчета минимальной продолжительности сна (в минутах)")
public class MinSleepSessionTest extends TestData {
    private static final List<SleepSession> sleepSessions = new ArrayList<>();
    private static final List<SleepSession> sleepSessions2 = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        sleepSessions.add(sleepSession);
        sleepSessions.add(sleepSession2);
        sleepSessions.add(sleepSession3);

        //добавляем две сессии с одинаково минимальным кол-ом минут
        sleepSessions2.add(sleepSession);
        sleepSessions2.add(sleepSession2);
        sleepSessions2.add(sleepSession3);
        sleepSessions2.add(sleepSession4);
    }

    @Test
    @DisplayName("Проверка подсчета минимальной продолжительности сна (в минутах)")
    public void check() {
        SleepAnalysisResult result = new MinSleepSession().apply(sleepSessions);
        GeneralAssertions.isEqualTo(200, result.getResult(),
                "Ожидаемая минимальная продолжительность сна '%d' не соответствует фактической '%d'");
    }

    @Test
    @DisplayName("Проверка подсчета минимальной продолжительности сна (в минутах)")
    public void check2() {
        SleepAnalysisResult result = new MinSleepSession().apply(sleepSessions2);
        GeneralAssertions.isEqualTo(200, result.getResult(),
                "Ожидаемая минимальная продолжительность сна '%d' не соответствует фактической '%d'");
    }
}
