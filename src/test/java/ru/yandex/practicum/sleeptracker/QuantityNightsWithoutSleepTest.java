package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.functions.QuantityNightsWithoutSleep;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Проверка подсчета количества бессонных ночей")
public class QuantityNightsWithoutSleepTest extends TestData {
    private static final List<SleepSession> nightSleepSessions = new ArrayList<>();
    private static final List<SleepSession> nightSleepSessions2 = new ArrayList<>();
    private static final List<SleepSession> notNightSleepSessions = new ArrayList<>();
    private static final List<SleepSession> notNightSleepSessions2 = new ArrayList<>();
    private static final List<SleepSession> notNightSleepSessions3 = new ArrayList<>();
    private static final List<SleepSession> sleepSessions = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        //ночная сессия сна
        nightSleepSessions.add(sleepSession6);
        //НЕ ночная сессия сна
        notNightSleepSessions.add(sleepSession7);
        //ночная сессия сна
        nightSleepSessions2.add(sleepSession8);
        //НЕ ночная сессия сна
        notNightSleepSessions2.add(sleepSession9);
        //добавление дат с переходом на новый месяц
        notNightSleepSessions3.add(sleepSession16);
        notNightSleepSessions3.add(sleepSession17);

        sleepSessions.add(sleepSession6);
        sleepSessions.add(sleepSession7);
        sleepSessions.add(sleepSession8);
        sleepSessions.add(sleepSession9);
    }

    @Test
    @DisplayName("Проверка, что ночь не считается бессонной, если задето начальное значение интервала - 00:00")
    public void check() {
        SleepAnalysisResult result = new QuantityNightsWithoutSleep().apply(nightSleepSessions);
        GeneralAssertions.isEqualTo(0, result.getResult(),
                "Ожидаемое кол-во бессонных ночей '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка, что ночь не считается бессонной, если задето конечное значение интервала - 06:00")
    public void check2() {
        SleepAnalysisResult result = new QuantityNightsWithoutSleep().apply(nightSleepSessions2);
        GeneralAssertions.isEqualTo(0, result.getResult(),
                "Ожидаемое кол-во бессонных ночей '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка, что ночь не считается бессонной," +
            " если время пробуждения не задело начальное значение интервала - 00:00," +
            "так как ночь еще не наступала")
    public void check3() {
        SleepAnalysisResult result = new QuantityNightsWithoutSleep().apply(notNightSleepSessions);
        GeneralAssertions.isEqualTo(0, result.getResult(),
                "Ожидаемое кол-во бессонных ночей '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка, что ночь считается бессонной," +
            " если время начала сна не задело конечное значение интервала - 06:00")
    public void check4() {
        SleepAnalysisResult result = new QuantityNightsWithoutSleep().apply(notNightSleepSessions2);
        GeneralAssertions.isEqualTo(1, result.getResult(),
                "Ожидаемое кол-во бессонных ночей '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка подсчета количества бессонных ночей")
    public void check5() {
        SleepAnalysisResult result = new QuantityNightsWithoutSleep().apply(sleepSessions);
        GeneralAssertions.isEqualTo(2, result.getResult(),
                "Ожидаемое кол-во бессонных ночей '%d' не соответствует фактическому '%d'");
    }

    @Test
    @DisplayName("Проверка подсчета количества бессонных ночей при переходе на другой месяц")
    public void check6() {
        SleepAnalysisResult result = new QuantityNightsWithoutSleep().apply(notNightSleepSessions3);
        GeneralAssertions.isEqualTo(1, result.getResult(),
                "Ожидаемое кол-во бессонных ночей '%d' не соответствует фактическому '%d'");
    }
}
