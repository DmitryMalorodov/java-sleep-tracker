package ru.yandex.practicum.sleeptracker.functions;

import ru.yandex.practicum.sleeptracker.dto.results.Result;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.dto.results.UserTypeResult;
import ru.yandex.practicum.sleeptracker.enums.UserType;
import ru.yandex.practicum.sleeptracker.helpers.Helper;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class CheckUserType implements Function<List<SleepSession>, Result> {
    private static final LocalTime larkAsleepTime = LocalTime.of(22, 0);
    private static final LocalTime owlAsleepTime = LocalTime.of(23, 0);
    private static final LocalTime owlAwakeTime = LocalTime.of(9, 0);
    private static final LocalTime larkAwakeTime = LocalTime.of(7, 0);

    @Override
    public UserTypeResult apply(List<SleepSession> sleepSessions) {
        List<SleepSession> nightSleepSessions = Helper.getNightSleepSessions(sleepSessions);

        AtomicInteger owlNights = new AtomicInteger(0);
        AtomicInteger larkNights = new AtomicInteger(0);
        AtomicInteger pigeonNights = new AtomicInteger(0);

        nightSleepSessions.forEach(session -> {
            if (session.getAsleepTime().toLocalTime().isAfter(owlAsleepTime)
            && session.getAwakeTime().toLocalTime().isAfter(owlAwakeTime)) {
                owlNights.incrementAndGet();
            } else if (session.getAsleepTime().toLocalTime().isBefore(larkAsleepTime)
            && session.getAwakeTime().toLocalTime().isBefore(larkAwakeTime)) {
                larkNights.incrementAndGet();
            } else {
                pigeonNights.incrementAndGet();
            }
        });

        UserType userType = UserType.getUserType(owlNights.get(), larkNights.get(), pigeonNights.get());
        return new UserTypeResult(userType.getUserType(), "Хронотип пользователя");
    }
}
