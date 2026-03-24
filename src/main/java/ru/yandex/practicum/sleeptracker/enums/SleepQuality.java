package ru.yandex.practicum.sleeptracker.enums;

import java.util.Arrays;

public enum SleepQuality {
    GOOD,
    NORMAL,
    BAD;

    public static SleepQuality getSleepQuantity(String sleepQuantity) {
        return Arrays.stream(values())
                .filter(value -> value.toString().equalsIgnoreCase(sleepQuantity))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
