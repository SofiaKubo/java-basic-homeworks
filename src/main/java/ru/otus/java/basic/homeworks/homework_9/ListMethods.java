package ru.otus.java.basic.homeworks.homework_9;

import java.util.ArrayList;
import java.util.List;

public class ListMethods {
    public static List<Integer> createRangeList(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                    "min must be less than or equal to max: min=" + min +
                            ", max=" + max + "."
            );
        }

        List<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            list.add(i);
        }

        return list;
    }

    public static int sumElementsGreaterThanFive(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(
                    "List is null."
            );
        }

        if (numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);

            if (number == null) {
                throw new IllegalArgumentException(
                        "List contains null element at index " + i + "."
                );
            }

            if (number > 5) {
                sum += number;
            }
        }

        return sum;
    }

    public static void fillList(List<Integer> numbers, int value) {
        if (numbers == null) {
            throw new IllegalArgumentException("List is null.");
        }

        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, value);
        }
    }

    public static void increaseAllElements(List<Integer> numbers, int value) {
        if (numbers == null) {
            throw new IllegalArgumentException("List is null.");
        }

        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);

            if (number == null) {
                throw new IllegalArgumentException(
                        "List contains null element at index " + i + "."
                );
            }

            numbers.set(i, number + value);
        }
    }

    public static List<String> getEmployeeNames(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list is null.");
        }

        List<String> names = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            if (employee == null) {
                throw new IllegalArgumentException(
                        "Employee list contains null element at index " + i +
                                "."
                );
            }

            String name = employee.getName();

            if (name == null) {
                throw new IllegalArgumentException(
                        "Employee name is null at index " + i + "."
                );
            }

            names.add(name);
        }

        return names;
    }

    public static List<Employee> getEmployeesByMinAge(List<Employee> employees, int minAge) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list is null.");
        }

        List<Employee> employeesByMinAge = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            if (employee == null) {
                throw new IllegalArgumentException(
                        "Employee list contains null element at index " + i +
                                "."
                );
            }

            int age = employee.getAge();

            if (age >= minAge) {
                employeesByMinAge.add(employee);
            }
        }

        return employeesByMinAge;
    }

    public static boolean isAverageAgeGreaterThan(List<Employee> employees, int minAverageAge) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list is null.");
        }

        if (employees.isEmpty()) {
            throw new IllegalArgumentException(
                    "Employee list is empty. Average age cannot be calculated."
            );
        }

        double totalAge = 0;

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            if (employee == null) {
                throw new IllegalArgumentException(
                        "Employee list contains null element at index " + i +
                                "."
                );
            }

            totalAge += employee.getAge();
        }

        double averageAge = totalAge / employees.size();

        return averageAge > minAverageAge;
    }

    public static Employee findYoungestEmployee(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list is null.");
        }

        if (employees.isEmpty()) {
            throw new IllegalArgumentException(
                    "Employee list is empty. Youngest employee cannot be found."
            );
        }

        Employee youngestEmployee = null;

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            if (employee == null) {
                throw new IllegalArgumentException(
                        "Employee list contains null element at index " + i +
                                "."
                );
            }

            if (youngestEmployee == null ||
                    employee.getAge() < youngestEmployee.getAge()) {
                youngestEmployee = employee;
            }
        }

        return youngestEmployee;
    }
}
