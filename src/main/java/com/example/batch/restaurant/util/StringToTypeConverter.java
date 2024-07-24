package com.example.batch.restaurant.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class StringToTypeConverter {

    public static Optional<Long> parseLong(String value) {
        try {
            return StringUtils.hasText(value) ? Optional.of(Long.valueOf(value)) : Optional.empty();
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Double> parseDouble(String value) {
        try {
            return StringUtils.hasText(value) ? Optional.of(Double.valueOf(value)) : Optional.empty();
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Integer> parseInteger(String value) {
        try {
            return StringUtils.hasText(value) ? Optional.of(Integer.valueOf(value)) : Optional.empty();
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<LocalDate> parseLocalDate(String value) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.M.dd");
            return StringUtils.hasText(value) ? Optional.of(LocalDate.parse(value, dateFormatter)) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static Optional<LocalDateTime> parseLocalDateTime(String value) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.M.dd H:m");
            return StringUtils.hasText(value) ? Optional.of(LocalDateTime.parse(value, dateTimeFormatter)) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}