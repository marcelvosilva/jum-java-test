package com.exercise.utils;

public class ValidateNumber {

    public static boolean validateNumber(String phoneNumber) {
        int firstParentheses = phoneNumber.indexOf("(");
        int lastParentheses = phoneNumber.indexOf(")");
        String code = phoneNumber.substring(firstParentheses + 1, lastParentheses);

        switch (code) {
            case "237":
                return phoneNumber.matches("\\(237\\) ?[2368]\\d{7,8}$");
            case "251":
                return phoneNumber.matches("\\(251\\) ?[1-59]\\d{8}$");
            case "212":
                return phoneNumber.matches("\\(212\\) ?[5-9]\\d{8}$");
            case "258":
                return phoneNumber.matches("\\(258\\) ?[28]\\d{7,8}$");
            case "256":
                return phoneNumber.matches("\\(256\\) ?\\d{9}$");
            default:
                return false;
        }
    }
    
}
