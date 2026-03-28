package ru.yandex.practicum.sleeptracker.enums;

public enum UserType {
    OWL("Сова"),
    LARK("Жаворонок"),
    PIGEON("Голубь");

    private final String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public static UserType getUserType(Integer owlNights, Integer larkNights, Integer pigeonNights) {
        if (owlNights > larkNights && owlNights > pigeonNights) return OWL;
        else if (larkNights > owlNights && larkNights > pigeonNights) return LARK;
        else return PIGEON;
    }
}
