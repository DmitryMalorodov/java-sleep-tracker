package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.functions.QuantityBadSleepSession;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Проверка подсчета количества сессий с плохим качеством сна")
public class QuantityBadSleepSessionTest extends TestData {
    private static final List<SleepSession> sessionsWithBadQuality = new ArrayList<>();
    private static final List<SleepSession> sessionsWithoutBadQuality = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        sessionsWithBadQuality.add(sleepSession);
        sessionsWithBadQuality.add(sleepSession2);
        sessionsWithBadQuality.add(sleepSession3);

        sessionsWithoutBadQuality.add(sleepSession);
        sessionsWithoutBadQuality.add(sleepSession3);
    }

    @Test
    @DisplayName("Проверка подсчета количества сессий с плохим качеством сна")
    public void check() {
        SleepAnalysisResult result = new QuantityBadSleepSession().apply(sessionsWithBadQuality);
        GeneralAssertions.isEqualTo(1, result.getResult(),
                "Ожидаемое кол-во сессий сна с плохим качеством '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка подсчета количества сессий с плохим качеством сна, когда таких сессий нет")
    public void check2() {
        SleepAnalysisResult result = new QuantityBadSleepSession().apply(sessionsWithoutBadQuality);
        GeneralAssertions.isEqualTo(0, result.getResult(),
                "Ожидаемое кол-во сессий сна с плохим качеством '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка обработки ситуации, когда нет ни одной сессии сна")
    public void check3() {
        checkNoSessionsCase(new QuantityBadSleepSession().apply(new ArrayList<>()));
    }
}
