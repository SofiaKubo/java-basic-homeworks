package ru.otus.java.basic.homeworks.homework_4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User[] users = {
                new User("Иванов", "Иван", "Сергеевич", 1967, "ivanov7@gmail.com"),
                new User("Петрова", "Анна", "Александровна", 1985, "petrova85@gmail.com"),
                new User("Сидоров", "Максим", "Олегович", 1992, "sidorov92@gmail.com"),
                new User("Кузнецова", "Мария", "Игоревна", 1978, "kuznetsova78@gmail.com"),
                new User("Смирнов", "Дмитрий", "Андреевич", 2001, "smirnov01@gmail.com"),
                new User("Васильева", "Екатерина", "Павловна", 1995, "vasilieva95@gmail.com"),
                new User("Морозов", "Алексей", "Викторович", 1980, "morozov80@gmail.com"),
                new User("Новикова", "Ольга", "Денисовна", 1970, "novikova70@gmail.com"),
                new User("Фёдоров", "Никита", "Романович", 2003, "fedorov03@gmail.com"),
                new User("Соколова", "Елена", "Михайловна", 1988, "sokolova88@gmail.com")
        };

        int currentYear = LocalDate.now().getYear();

        for (User user : users) {
            if (currentYear - user.getBirthYear() > 40) {
                user.printInfo();
                System.out.println();
            }
        }
    }
}
