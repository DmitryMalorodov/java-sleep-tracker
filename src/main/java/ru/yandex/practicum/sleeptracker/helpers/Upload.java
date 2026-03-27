package ru.yandex.practicum.sleeptracker.helpers;

import ru.yandex.practicum.sleeptracker.dto.SleepSession;
import ru.yandex.practicum.sleeptracker.enums.SleepQuality;
import ru.yandex.practicum.sleeptracker.exceptions.SleepSessionsNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Upload {
    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

    public static List<SleepSession> uploadFile(String path) throws SleepSessionsNotFoundException, FileNotFoundException {
        List<SleepSession> sleepSessions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().forEach(sleepSession -> {
                String[] sleepData = sleepSession.split(";");
                sleepSessions.add(new SleepSession(
                        LocalDateTime.parse(sleepData[0], PATTERN),
                        LocalDateTime.parse(sleepData[1], PATTERN),
                        SleepQuality.getSleepQuantity(sleepData[2])
                ));
            });
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Не удалось загрузить файл!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (sleepSessions.isEmpty())
            throw new SleepSessionsNotFoundException("Нет ни одной сессии сна для анализа!");

        return sleepSessions;
    }
}
