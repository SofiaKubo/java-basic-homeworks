package ru.otus.java.basic.homeworks.homework_4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[10];
        users[0] = new User("Иванов", "Иван", "Сергеевич", 1967, "ivanov7@gmail.com");
        users[1] = new User("Петрова", "Анна", "Александровна", 1985, "petrova85@gmail.com");
        users[2] = new User("Сидоров", "Максим", "Олегович", 1992, "sidorov92@gmail.com");
        users[3] = new User("Кузнецова", "Мария", "Игоревна", 1978, "kuznetsova78@gmail.com");
        users[4] = new User("Смирнов", "Дмитрий", "Андреевич", 2001, "smirnov01@gmail.com");
        users[5] = new User("Васильева", "Екатерина", "Павловна", 1995, "vasilieva95@gmail.com");
        users[6] = new User("Морозов", "Алексей", "Викторович", 1980, "morozov80@gmail.com");
        users[7] = new User("Новикова", "Ольга", "Денисовна", 1970, "novikova70@gmail.com");
        users[8] = new User("Фёдоров", "Никита", "Романович", 2003, "fedorov03@gmail.com");
        users[9] = new User("Соколова", "Елена", "Михайловна", 1988, "sokolova88@gmail.com");

        int currentYear = LocalDate.now().getYear();

        for (User user : users) {
            if (currentYear - user.getBirthYear() > 40) {
                user.printInfo();
                System.out.println();
            }
        }
    }
}
