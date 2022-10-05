package com.cg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ParsingValidationUtils {
    public static boolean isLongParsable(String number) {
        try {
            Long.parseLong(number);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
