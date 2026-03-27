package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.functions.AverageSleepSession;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Проверка средней продолжительности сна (в минутах)")
public class AverageSleepSessionTest extends TestData {
    private static final List<SleepSession> sleepSessions = new ArrayList<>();
    private static final List<SleepSession> sleepSessions2 = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        sleepSessions.add(sleepSession);

        sleepSessions2.add(sleepSession);
        sleepSessions2.add(sleepSession2);
        sleepSessions2.add(sleepSession3);
        sleepSessions2.add(sleepSession5);
    }

    @Test
    @DisplayName("Проверка вычисления средней продолжительности сна из одной сессии")
    public void check() {
        SleepAnalysisResult result = new AverageSleepSession().apply(sleepSessions);
        GeneralAssertions.isEqualTo(480, result.getResult(),
                "Ожидаемая средняя продолжительность сна '%d' не соответствует фактической '%d'");
    }

    @Test
    @DisplayName("Проверка вычисления средней продолжительности сна из множества сессий")
    public void check2() {
        SleepAnalysisResult result = new AverageSleepSession().apply(sleepSessions2);
        GeneralAssertions.isEqualTo(470, result.getResult(),
                "Ожидаемая средняя продолжительность сна '%d' не соответствует фактической '%d'");
    }
}
