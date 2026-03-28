package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.time.LocalDateTime;
import java.time.Month;

import static ru.yandex.practicum.sleeptracker.enums.SleepQuality.*;

public class TestData {
    static final String NO_SESSION_MESSAGE = "Нет ни одной сессии сна для расчета";

    static final SleepSession sleepSession = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 1, 22, 0),
            LocalDateTime.of(2026, Month.JANUARY, 2, 6, 0),
            GOOD
    );

    static final SleepSession sleepSession2 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 2, 23, 0),
            LocalDateTime.of(2026, Month.JANUARY, 3, 9, 0),
            BAD
    );

    static final SleepSession sleepSession3 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 3, 15, 20),
            LocalDateTime.of(2026, Month.JANUARY, 3, 18, 40),
            NORMAL
    );

    static final SleepSession sleepSession4 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 4, 15, 20),
            LocalDateTime.of(2026, Month.JANUARY, 4, 18, 40),
            NORMAL
    );

    static final SleepSession sleepSession5 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 4, 23, 0),
            LocalDateTime.of(2026, Month.JANUARY, 5, 9, 0),
            NORMAL
    );

    static final SleepSession sleepSession6 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 5, 23, 30),
            LocalDateTime.of(2026, Month.JANUARY, 6, 0, 0),
            NORMAL
    );

    static final SleepSession sleepSession7 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 6, 23, 30),
            LocalDateTime.of(2026, Month.JANUARY, 6, 23, 59),
            NORMAL
    );

    static final SleepSession sleepSession8 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 8, 6, 0),
            LocalDateTime.of(2026, Month.JANUARY, 8, 9, 0),
            NORMAL
    );

    static final SleepSession sleepSession9 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 9, 6, 1),
            LocalDateTime.of(2026, Month.JANUARY, 9, 9, 0),
            NORMAL
    );

    static final SleepSession sleepSession10 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 10, 23, 1),
            LocalDateTime.of(2026, Month.JANUARY, 11, 9, 1),
            NORMAL
    );

    static final SleepSession sleepSession11 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 11, 23, 59),
            LocalDateTime.of(2026, Month.JANUARY, 12, 10, 1),
            NORMAL
    );

    static final SleepSession sleepSession12 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 12, 21, 59),
            LocalDateTime.of(2026, Month.JANUARY, 13, 6, 59),
            NORMAL
    );

    static final SleepSession sleepSession13 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 13, 20, 59),
            LocalDateTime.of(2026, Month.JANUARY, 14, 4, 59),
            NORMAL
    );

    static final SleepSession sleepSession14 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 14, 22, 0),
            LocalDateTime.of(2026, Month.JANUARY, 15, 7, 0),
            NORMAL
    );

    static final SleepSession sleepSession15 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 15, 23, 0),
            LocalDateTime.of(2026, Month.JANUARY, 16, 9, 0),
            NORMAL
    );

    static final SleepSession sleepSession16 = new SleepSession(
            LocalDateTime.of(2026, Month.JANUARY, 30, 22, 0),
            LocalDateTime.of(2026, Month.JANUARY, 31, 10, 0),
            NORMAL
    );

    static final SleepSession sleepSession17 = new SleepSession(
            LocalDateTime.of(2026, Month.FEBRUARY, 1, 22, 1),
            LocalDateTime.of(2026, Month.FEBRUARY, 2, 9, 0),
            NORMAL
    );

    void checkNoSessionsCase(SleepAnalysisResult result) {
        GeneralAssertions.isEqualTo(NO_SESSION_MESSAGE, result.getResult(),
                "Ожидаемое сообщение об отсутствии сессий '%s' не соответствует фактическому '%s'");
    }
}