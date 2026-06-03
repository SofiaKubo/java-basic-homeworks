package ru.otus.java.basic.homeworks.homework_10;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private final Map<String, Set<String>> phoneNumbersByName;

    public PhoneBook() {
        phoneNumbersByName = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        String normalizedName = normalizeRequiredString(name, "Name");
        String normalizedPhoneNumber = normalizeRequiredString(phoneNumber, "Phone number");

        phoneNumbersByName
                .computeIfAbsent(normalizedName, key -> new HashSet<>())
                .add(normalizedPhoneNumber);
    }

    public Set<String> find(String name) {
        String normalizedName = normalizeRequiredString(name, "Name");

        Set<String> phoneNumbers = phoneNumbersByName.get(normalizedName);

        if (phoneNumbers == null) {
            return Collections.emptySet();
        }
        return new HashSet<>(phoneNumbers);
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        String normalizedPhoneNumber = normalizeRequiredString(phoneNumber, "Phone number");

        for (Set<String> phoneNumbers : phoneNumbersByName.values()) {
            if (phoneNumbers.contains(normalizedPhoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private static String normalizeRequiredString(String value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(
                    fieldName + " must not be null.");
        }

        String normalizedValue = value.trim();
        if (normalizedValue.isEmpty()) {
            throw new IllegalArgumentException(
                    fieldName + " must not be blank.");
        }
        return normalizedValue;
    }

    @Override
    public String toString() {
        if (phoneNumbersByName.isEmpty()) {
            return "Phone book is empty.";
        }

        StringBuilder result = new StringBuilder("Phone book:");
        result.append("\n");

        for (Map.Entry<String, Set<String>> entry : phoneNumbersByName.entrySet()) {
            result.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return result.toString();
    }
}
