package ru.yandex.practicum.sleeptracker.exceptions;

public class SleepSessionsNotFoundException extends RuntimeException {

    public SleepSessionsNotFoundException(String message) {
        super(message);
    }
}
