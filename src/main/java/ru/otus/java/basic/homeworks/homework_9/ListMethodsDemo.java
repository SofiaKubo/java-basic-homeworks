package ru.otus.java.basic.homeworks.homework_9;

import java.util.ArrayList;
import java.util.List;

public class ListMethodsDemo {
    public static void runAll() {
        demoCreateRangeList();
        demoSumElementsGreaterThanFive();
        demoFillList();
        demoIncreaseAllElements();
        demoGetEmployeeNames();
        demoGetEmployeesByMinAge();
        demoIsAverageAgeGreaterThan();
        demoFindYoungestEmployee();
    }

    private static void demoCreateRangeList() {
        System.out.println("Demo: createRangeList");
        System.out.println(
                "createRangeList(1, 5): " + ListMethods.createRangeList(1, 5));
        System.out.println(
                "createRangeList(5, 5): " + ListMethods.createRangeList(5, 5));
        System.out.println("createRangeList(-5, -10): " +
                ListMethods.createRangeList(-5, -10));
        System.out.println();
    }

    private static void demoSumElementsGreaterThanFive() {
        System.out.println("Demo: sumElementsGreaterThanFive");

        testSumElementsGreaterThanFive("Correct list", createStandardIntegerList());
        testSumElementsGreaterThanFive("Empty list", new ArrayList<>());
        testSumElementsGreaterThanFive("List with null element", createIntegerListWithNull());
    }

    private static void demoFillList() {
        System.out.println("Demo: fillList");

        testFillList("Correct list", createStandardIntegerList(), 1);
        testFillList("List with null element", createIntegerListWithNull(), 4);
    }

    private static void demoIncreaseAllElements() {
        System.out.println("Demo: increaseAllElements");

        testIncreaseAllElements("Correct list", createStandardIntegerList(), 10);
        testIncreaseAllElements("Negative value", createPositiveIntegerList(), -10);
        testIncreaseAllElements("List with null element", createIntegerListWithNull(), 4);
    }

    private static void demoGetEmployeeNames() {
        System.out.println("Demo: getEmployeeNames");

        testGetEmployeeNames("Correct employee list", createEmployees());
        testGetEmployeeNames("Empty employee list", new ArrayList<>());
        testGetEmployeeNames("Employee list with null element", createEmployeesWithNull());
    }

    private static void demoGetEmployeesByMinAge() {
        System.out.println("Demo: getEmployeesByMinAge");

        testGetEmployeesByMinAge("Correct employee list", createEmployees(), 30);
        testGetEmployeesByMinAge("No matching employees", createEmployees(), 50);
        testGetEmployeesByMinAge("Empty employee list", new ArrayList<>(), 30);
    }

    private static void demoIsAverageAgeGreaterThan() {
        System.out.println("Demo: isAverageAgeGreaterThan");

        testIsAverageAgeGreaterThan("Average age greater than threshold", createEmployees(), 30);
        testIsAverageAgeGreaterThan("Average age below threshold", createEmployees(), 50);
        testIsAverageAgeGreaterThan("Average age equals threshold", createEmployeesWithAverageAgeThirty(), 30);
        testIsAverageAgeGreaterThan("Empty employee list", new ArrayList<>(), 30);
    }

    private static void demoFindYoungestEmployee() {
        System.out.println("Demo: findYoungestEmployee");

        testFindYoungestEmployee("Correct employee list", createEmployees());
        testFindYoungestEmployee("Empty employee list", new ArrayList<>());
        testFindYoungestEmployee("Employee list with null element", createEmployeesWithNull());
    }

    private static void testSumElementsGreaterThanFive(String testName, List<Integer> list) {
        System.out.println("Test: " + testName);

        try {
            int result = ListMethods.sumElementsGreaterThanFive(list);
            System.out.println("List: " + list);
            System.out.println("Sum:  " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println();
    }

    private static void testFillList(String testName, List<Integer> numbers, int value) {
        System.out.println("Test: " + testName);

        try {
            System.out.println("Before: " + numbers);
            System.out.println("Value:  " + value);
            ListMethods.fillList(numbers, value);
            System.out.println("After:  " + numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println();
    }

    private static void testIncreaseAllElements(String testName, List<Integer> numbers, int value) {
        System.out.println("Test: " + testName);

        try {
            System.out.println("Before: " + numbers);
            System.out.println("Value:  " + value);
            ListMethods.increaseAllElements(numbers, value);
            System.out.println("After:  " + numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println();
    }

    private static void testGetEmployeeNames(String testName, List<Employee> employees) {
        System.out.println("Test: " + testName);

        try {
            System.out.println("Employees: " + employees);
            List<String> names = ListMethods.getEmployeeNames(employees);
            System.out.println("Names:     " + names);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println();
    }

    private static void testGetEmployeesByMinAge(String testName, List<Employee> employees, int minAge) {
        System.out.println("Test: " + testName);

        try {
            System.out.println("Employees: " + employees);
            System.out.println("Min age:   " + minAge);
            List<Employee> employeesByMinAge = ListMethods.getEmployeesByMinAge(employees, minAge);
            System.out.println("Result:    " + employeesByMinAge);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println();
    }

    private static void testIsAverageAgeGreaterThan(String testName, List<Employee> employees, int minAverageAge) {
        System.out.println("Test: " + testName);

        try {
            System.out.println("Employees: " + employees);
            System.out.println("Min average age: " + minAverageAge);

            boolean result = ListMethods.isAverageAgeGreaterThan(employees, minAverageAge);

            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println();
    }

    private static void testFindYoungestEmployee(String testName, List<Employee> employees) {
        System.out.println("Test: " + testName);

        try {
            System.out.println("Employees: " + employees);

            Employee youngestEmployee = ListMethods.findYoungestEmployee(employees);

            System.out.println("Youngest employee: " + youngestEmployee);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }

        System.out.println();
    }

    private static List<Integer> createStandardIntegerList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-5);
        numbers.add(3);
        numbers.add(15);
        numbers.add(10);
        numbers.add(-7);

        return numbers;
    }

    private static List<Integer> createPositiveIntegerList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        return numbers;
    }

    private static List<Integer> createIntegerListWithNull() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(null);
        numbers.add(10);

        return numbers;
    }

    private static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan", 34));
        employees.add(new Employee("Anna", 23));
        employees.add(new Employee("Elena", 46));
        employees.add(new Employee("Maria", 30));

        return employees;
    }

    private static List<Employee> createEmployeesWithNull() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan", 34));
        employees.add(null);
        employees.add(new Employee("Elena", 46));

        return employees;
    }

    private static List<Employee> createEmployeesWithAverageAgeThirty() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", 20));
        employees.add(new Employee("Maria", 30));
        employees.add(new Employee("Petr", 40));

        return employees;
    }
}