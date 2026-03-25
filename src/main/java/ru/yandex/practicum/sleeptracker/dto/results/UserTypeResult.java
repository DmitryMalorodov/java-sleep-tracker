package ru.yandex.practicum.sleeptracker.dto.results;

public class UserTypeResult extends Result {
    private final String userType;

    public UserTypeResult(String userType, String description) {
        super(description);
        this.userType = userType;
    }

    @Override
    public String getResult() {
        return userType;
    }
}
