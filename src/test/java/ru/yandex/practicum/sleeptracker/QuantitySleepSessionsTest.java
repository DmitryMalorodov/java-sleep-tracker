package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.results.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.functions.QuantitySleepSessions;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Проверка подсчета количества всех сессий сна")
public class QuantitySleepSessionsTest extends TestData {
    private static final List<SleepSession> sleepSessions = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        sleepSessions.add(sleepSession);
        sleepSessions.add(sleepSession2);
    }

    @Test
    @DisplayName("Проверка подсчета количества всех сессий сна")
    public void check() {
        SleepAnalysisResult result = new QuantitySleepSessions().apply(sleepSessions);
        GeneralAssertions.isEqualTo(2, result.getResult(),
                "Ожидаемое кол-во всех сессий сна '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка подсчета количества всех сессий сна")
    public void check2() {
        SleepAnalysisResult result = new QuantitySleepSessions().apply(new ArrayList<>());
        GeneralAssertions.isEqualTo(0, result.getResult(),
                "Ожидаемое кол-во всех сессий сна '%d' не соответствует фактическому '%d'");
    }
}
