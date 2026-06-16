package ru.otus.java.basic.homeworks.homework_13;

public class Calculator {

    public double calculate(
            double leftOperand,
            double rightOperand,
            String operation
    ) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation must not be null.");
        }

        String normalizedOperation = operation.strip();

        if (normalizedOperation.isBlank()) {
            throw new IllegalArgumentException("Operation must not be blank.");
        }

        return switch (normalizedOperation) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> {
                if (rightOperand == 0) {
                    throw new IllegalArgumentException(
                            "Division by zero is not allowed."
                    );
                }

                yield leftOperand / rightOperand;
            }
            default -> throw new IllegalArgumentException(
                    "Unsupported operation: " + normalizedOperation
            );
        };
    }
}
