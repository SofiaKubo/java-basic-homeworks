package ru.otus.java.basic.homeworks.homework_13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final String CLIENT_LOG_PREFIX = "[CLIENT] ";
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8091;
    private static final String EXIT_COMMAND = "exit";
    private static final String REQUEST_DELIMITER = ";";
    private static final Logger logger = LoggerFactory.getLogger(CalculatorClient.class);

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                Socket clientSocket = new Socket(SERVER_HOST, SERVER_PORT)
        ) {
            logger.info(
                    "{}Connected to server at {}:{}.",
                    CLIENT_LOG_PREFIX,
                    SERVER_HOST,
                    SERVER_PORT
            );

            handleServerSession(clientSocket, scanner);
        } catch (IOException e) {
            logger.error(
                    "{}Failed to communicate with server at {}:{}: {}",
                    CLIENT_LOG_PREFIX,
                    SERVER_HOST,
                    SERVER_PORT,
                    e.getMessage(),
                    e
            );
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
                logger.info(
                        "{}Server disconnected before sending available operations.",
                        CLIENT_LOG_PREFIX
                );
                return;
            }

            logger.info(availableOperationsMessage);

            while (true) {
                String request = readRequest(scanner);

                sendMessage(bufferedWriter, request);
                logger.info("{}Request sent: {}", CLIENT_LOG_PREFIX, request);

                if (EXIT_COMMAND.equals(request)) {
                    logger.info("{}Session finished.", CLIENT_LOG_PREFIX);
                    return;
                }

                String response = bufferedReader.readLine();

                if (response == null) {
                    logger.info(
                            "{}Server disconnected without sending a response.",
                            CLIENT_LOG_PREFIX
                    );
                    return;
                }

                logger.info("{}Response received: {}", CLIENT_LOG_PREFIX, response);
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
