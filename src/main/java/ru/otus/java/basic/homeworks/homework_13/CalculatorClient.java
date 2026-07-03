package ru.otus.java.basic.homeworks.homework_13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CalculatorClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8091;
    private static final String EXIT_COMMAND = "exit";
    private static final String REQUEST_DELIMITER = ";";

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                Socket clientSocket = new Socket(SERVER_HOST, SERVER_PORT)
        ) {
            System.out.println(
                    "[CLIENT] Connected to server at "
                            + SERVER_HOST + " :" + SERVER_PORT + "."
            );

            handleServerSession(clientSocket, scanner);
        } catch (IOException e) {
            System.err.println(
                    "[CLIENT] Failed to communicate with server at "
                            + SERVER_HOST + ":" + SERVER_PORT
                            + ": " + e.getMessage()
            );
            e.printStackTrace();
        }
    }

    private static void handleServerSession(
            Socket clientSocket,
            Scanner scanner
    ) throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                inputStream,
                                StandardCharsets.UTF_8
                        )
                );
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(
                                outputStream,
                                StandardCharsets.UTF_8
                        )
                )
        ) {
            String availableOperationsMessage = bufferedReader.readLine();

            if (availableOperationsMessage == null) {
                System.out.println(
                        "[CLIENT] Server disconnected before sending "
                                + "available operations."
                );
                return;
            }

            System.out.println(availableOperationsMessage);

            while (true) {
                String request = readRequest(scanner);

                sendMessage(bufferedWriter, request);
                System.out.println("[CLIENT] Request sent: " + request);

                if (EXIT_COMMAND.equals(request)) {
                    System.out.println("[CLIENT] Session finished.");
                    return;
                }

                String response = bufferedReader.readLine();

                if (response == null) {
                    System.out.println(
                            "[CLIENT] Server disconnected without sending a response."
                    );
                    return;
                }

                System.out.println("[CLIENT] Response received: " + response);
            }
        }
    }

    private static String readRequest(Scanner scanner) {
        System.out.println(
                "Enter the first number or \""
                        + EXIT_COMMAND
                        + "\" to finish:"
        );

        String firstInput = scanner.nextLine().strip();
        if (EXIT_COMMAND.equalsIgnoreCase(firstInput)) {
            return EXIT_COMMAND;
        }

        System.out.println("Enter an operation (+, -, *, /) or \""
                + EXIT_COMMAND
                + "\" to finish:");

        String operation = scanner.nextLine().strip();
        if (EXIT_COMMAND.equalsIgnoreCase(operation)) {
            return EXIT_COMMAND;
        }

        System.out.println("Enter the second number or \""
                + EXIT_COMMAND
                + "\" to finish:");

        String rightOperand = scanner.nextLine().strip();
        if (EXIT_COMMAND.equalsIgnoreCase(rightOperand)) {
            return EXIT_COMMAND;
        }

        return String.join(
                REQUEST_DELIMITER,
                firstInput,
                operation,
                rightOperand
        );
    }

    private static void sendMessage(
            BufferedWriter bufferedWriter,
            String message
    ) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
