package ru.yandex.practicum.sleeptracker.helpers;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private static final LocalTime SIX_AM = LocalTime.of(6, 0);
    private static final LocalTime MIDNIGHT = LocalTime.MIDNIGHT;

    private Helper() {
    }

    public static List<Duration> getSleepSessionsDurations(List<SleepSession> sleepSessions) {
        List<Duration> durations = new ArrayList<>();

        sleepSessions.forEach(session ->
                durations.add(Duration.between(session.getAsleepTime(), session.getAwakeTime())));

        return durations;
    }

    /**
     * Получение всех сессий сна пользователя входящих в интервал 00:00 - 06:00
     * @param sleepSessions - все сессии сна
     * @return - все сессии сна пользователя входящих в интервал 00:00 - 06:00
     */
    public static List<SleepSession> getNightSleepSessions(List<SleepSession> sleepSessions) {
        List<SleepSession> nightSleepSessions = new ArrayList<>();

        sleepSessions.forEach(session -> {
            if (session.getAsleepTime().getDayOfMonth() != session.getAwakeTime().getDayOfMonth()) {
                nightSleepSessions.add(session);
            } else if (!session.getAsleepTime().toLocalTime().isBefore(MIDNIGHT)
                    && !session.getAsleepTime().toLocalTime().isAfter(SIX_AM)) {
                nightSleepSessions.add(session);
            } else if (!session.getAwakeTime().toLocalTime().isBefore(MIDNIGHT)
                    && !session.getAwakeTime().toLocalTime().isAfter(SIX_AM)) {
                nightSleepSessions.add(session);
            }
        });

        return nightSleepSessions;
    }

    /**
     * Получение кол-ва ночей, когда пользователь спал
     * @param sleepSessions - все сессии сна
     * @return - кол-во ночей, когда пользователь спал
     */
    public static int getNightSleepQuantity(List<SleepSession> sleepSessions) {
        List<SleepSession> nightSleepSessions = new ArrayList<>();

        //кладем в это поле дату, когда добавляем в список сессию,
        //чтобы при дальнейших добавлениях учитывать посчитали эту ночь уже или нет
        final LocalDate[] localDate = new LocalDate[1];
        localDate[0] = sleepSessions.getFirst().getAsleepTime().toLocalDate().minusDays(1);

        sleepSessions.forEach(session -> {
            if (session.getAsleepTime().getDayOfMonth() != session.getAwakeTime().getDayOfMonth()) {
                nightSleepSessions.add(session);
                localDate[0] = session.getAwakeTime().toLocalDate();
            } else if (!session.getAsleepTime().toLocalTime().isBefore(MIDNIGHT)
                    && !session.getAsleepTime().toLocalTime().isAfter(SIX_AM)
                    && localDate[0].getDayOfMonth() != session.getAsleepTime().getDayOfMonth()) {
                nightSleepSessions.add(session);
                localDate[0] = session.getAsleepTime().toLocalDate();
            } else if (!session.getAwakeTime().toLocalTime().isBefore(MIDNIGHT)
                    && !session.getAwakeTime().toLocalTime().isAfter(SIX_AM)
                    && localDate[0].getDayOfMonth() != session.getAwakeTime().getDayOfMonth()) {
                nightSleepSessions.add(session);
                localDate[0] = session.getAsleepTime().toLocalDate();
            }
        });

        return nightSleepSessions.size();
    }
}
