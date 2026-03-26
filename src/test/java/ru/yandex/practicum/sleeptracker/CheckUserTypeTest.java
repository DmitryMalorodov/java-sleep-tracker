package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.results.UserTypeResult;
import ru.yandex.practicum.sleeptracker.functions.CheckUserType;
import ru.yandex.practicum.sleeptracker.helpers.GeneralAssertions;

import java.util.ArrayList;
import java.util.List;

import static ru.yandex.practicum.sleeptracker.enums.UserType.*;

@DisplayName("Проверка определения хронотипа пользователя")
public class CheckUserTypeTest extends TestData {
    private static final List<SleepSession> sleepSessionsOwl = new ArrayList<>();
    private static final List<SleepSession> sleepSessionsLark = new ArrayList<>();
    private static final List<SleepSession> sleepSessionsPigeon = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        sleepSessionsOwl.add(sleepSession10);
        sleepSessionsOwl.add(sleepSession11);
        sleepSessionsOwl.add(sleepSession12);
        sleepSessionsOwl.add(sleepSession14);

        sleepSessionsLark.add(sleepSession12);
        sleepSessionsLark.add(sleepSession13);
        sleepSessionsLark.add(sleepSession10);
        sleepSessionsLark.add(sleepSession15);

        sleepSessionsPigeon.add(sleepSession14);
        sleepSessionsPigeon.add(sleepSession15);
        sleepSessionsPigeon.add(sleepSession11);
        sleepSessionsPigeon.add(sleepSession13);
    }

    @Test
    @DisplayName("Проверка определения хронотипа пользователя")
    public void check() {
        UserTypeResult result = new CheckUserType().apply(sleepSessionsOwl);
        GeneralAssertions.isEqualTo(OWL.getUserType(), result.getResult(),
                "Ожидаемый хронотип пользователя '%s' не соответствует фактическому '%s'");
    }

    @Test
    @DisplayName("Проверка определения хронотипа пользователя")
    public void check2() {
        UserTypeResult result = new CheckUserType().apply(sleepSessionsLark);
        GeneralAssertions.isEqualTo(LARK.getUserType(), result.getResult(),
                "Ожидаемый хронотип пользователя '%s' не соответствует фактическому '%s'");
    }

    @Test
    @DisplayName("Проверка определения хронотипа пользователя")
    public void check3() {
        UserTypeResult result = new CheckUserType().apply(sleepSessionsPigeon);
        GeneralAssertions.isEqualTo(PIGEON.getUserType(), result.getResult(),
                "Ожидаемый хронотип пользователя '%s' не соответствует фактическому '%s'");
    }
}
