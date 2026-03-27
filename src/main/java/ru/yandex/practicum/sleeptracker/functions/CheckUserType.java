package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.enums.UserType;
import ru.yandex.practicum.sleeptracker.helpers.Helper;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class CheckUserType implements Function<List<SleepSession>, SleepAnalysisResult> {
    private static final String FUNC_DESCRIPTION = "Хронотип пользователя";
    private static final LocalTime LARK_ASLEEP_TIME = LocalTime.of(22, 0);
    private static final LocalTime OWL_ASLEEP_TIME = LocalTime.of(23, 0);
    private static final LocalTime OWL_AWAKE_TIME = LocalTime.of(9, 0);
    private static final LocalTime LARK_AWAKE_TIME = LocalTime.of(7, 0);

    @Override
    public SleepAnalysisResult apply(List<SleepSession> sleepSessions) {
        List<SleepSession> nightSleepSessions = Helper.getNightSleepSessions(sleepSessions);

        AtomicInteger owlNights = new AtomicInteger(0);
        AtomicInteger larkNights = new AtomicInteger(0);
        AtomicInteger pigeonNights = new AtomicInteger(0);

        nightSleepSessions.forEach(session -> {
            if (session.getAsleepTime().toLocalTime().isAfter(OWL_ASLEEP_TIME)
                    && session.getAwakeTime().toLocalTime().isAfter(OWL_AWAKE_TIME)) {
                owlNights.incrementAndGet();
            } else if (session.getAsleepTime().toLocalTime().isBefore(LARK_ASLEEP_TIME)
                    && session.getAwakeTime().toLocalTime().isBefore(LARK_AWAKE_TIME)) {
                larkNights.incrementAndGet();
            } else {
                pigeonNights.incrementAndGet();
            }
        });

        UserType userType = UserType.getUserType(owlNights.get(), larkNights.get(), pigeonNights.get());
        return new SleepAnalysisResult(userType.getUserType(), FUNC_DESCRIPTION);
    }
}
