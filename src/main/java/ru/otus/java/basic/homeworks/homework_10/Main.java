package ru.otus.java.basic.homeworks.homework_10;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        fillPhoneBook(phoneBook);
        demoFind(phoneBook);
        demoContainsPhoneNumber(phoneBook);
        demoInvalidInput(phoneBook);
    }

    private static void fillPhoneBook(PhoneBook phoneBook) {
        phoneBook.add("Иванов Иван Иванович", "+79153585678");
        phoneBook.add("Иванов Иван Иванович", "+79206582131");
        phoneBook.add("Иванов Иван Иванович", "+79153585678");

        phoneBook.add("Сергеев Владислав Никифорович", "+79181456734");
        phoneBook.add("Петрова Анна Петровна", "+79150813279");

        phoneBook.add(" Лютова Елена Ростиславовна ", " +79186762545 ");
    }

    private static void demoFind(PhoneBook phoneBook) {
        printSection("Find by name");

        printFindResult(phoneBook, "Иванов Иван Иванович");
        printFindResult(phoneBook, "Лютова Елена Ростиславовна");
        printFindResult(phoneBook, "Ааронова Инга Ивановна");

        System.out.println();
    }

    private static void demoContainsPhoneNumber(PhoneBook phoneBook) {
        printSection("Contains phone number");

        printContainsResult(phoneBook, "+79153585678");
        printContainsResult(phoneBook, "+7915");
        printContainsResult(phoneBook, " +79186762545 ");

        System.out.println();
    }

    private static void demoInvalidInput(PhoneBook phoneBook) {
        printSection("Invalid input");

        tryAdd(phoneBook, null, "+79183565675");
        tryAdd(phoneBook, "Иванов Иван Иванович", "  ");
        tryFind(phoneBook, "  ");
        tryContainsPhoneNumber(phoneBook, null);

        System.out.println();
    }

    private static void printFindResult(PhoneBook phoneBook, String name) {
        Set<String> phoneNumbers = phoneBook.find(name);

        if (phoneNumbers.isEmpty()) {
            System.out.println(name + ": contact not found");
        } else {
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    private static void printContainsResult(PhoneBook phoneBook, String phoneNumber) {
        System.out.println(phoneNumber + ": "
                + phoneBook.containsPhoneNumber(phoneNumber));
    }

    private static void tryAdd(PhoneBook phoneBook, String name, String phoneNumber) {
        try {
            phoneBook.add(name, phoneNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("add error: " + e.getMessage());
        }
    }

    private static void tryFind(PhoneBook phoneBook, String name) {
        try {
            phoneBook.find(name);
        } catch (IllegalArgumentException e) {
            System.out.println("find error: " + e.getMessage());
        }
    }

    private static void tryContainsPhoneNumber(PhoneBook phoneBook, String phoneNumber) {
        try {
            phoneBook.containsPhoneNumber(phoneNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("containsPhoneNumber error: "
                    + e.getMessage());
        }
    }

    private static void printSection(String title) {
        System.out.println("----- " + title + " -----");
    }
}