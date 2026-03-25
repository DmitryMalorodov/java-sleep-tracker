package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.dto.results.Result;
import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.exceptions.SleepSessionsNotFoundException;
import ru.yandex.practicum.sleeptracker.functions.*;
import ru.yandex.practicum.sleeptracker.helpers.Upload;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {
    private static List<SleepSession> sleepSessions;
    private static final List<Function<List<SleepSession>, Result>> functions = new ArrayList<>();

    static {
        functions.add(new QuantitySleepSessions());
        functions.add(new MinSleepSession());
        functions.add(new MaxSleepSession());
        functions.add(new AverageSleepSession());
        functions.add(new QuantityBadSleepSession());
        functions.add(new QuantityNightsWithoutSleep());
        functions.add(new CheckUserType());
    }

    public static void main(String[] args) {
        try {
            sleepSessions = Upload.uploadFile(args[0]);
        } catch (SleepSessionsNotFoundException | FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        functions.forEach(function -> {
            Result result = function.apply(sleepSessions);
            System.out.println(String.format("%s: %s", result.getDescription(),
                    result.getResult()));
        });
    }
}