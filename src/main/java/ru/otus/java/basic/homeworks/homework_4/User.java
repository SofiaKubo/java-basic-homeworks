package ru.otus.java.basic.homeworks.homework_4;

public class User {
    private String lastName;
    private String firstName;
    private String middleName;
    private int birthYear;
    private String email;


    public User(String lastName, String firstName, String middleName, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void printInfo() {
        System.out.println(
                "ФИО: " + lastName + " " + firstName + " " + middleName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
    }
}

