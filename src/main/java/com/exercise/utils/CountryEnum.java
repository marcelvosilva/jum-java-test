package com.exercise.utils;

public enum CountryEnum {
    Cameroon(237),
    Ethiopia(251),
    Morocco(212),
    Mozambique(258),
    Uganda(256);

    int countryCode;

    CountryEnum(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getCode() {
        return countryCode;
    }
}
