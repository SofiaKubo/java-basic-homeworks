package ru.otus.java.basic.homeworks.homework_13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CalculatorServer {
    private static final int SERVER_PORT = 8091;
    private static final String EXIT_COMMAND = "exit";
    private static final String REQUEST_DELIMITER = ";";
    private static final String AVAILABLE_OPERATIONS_MESSAGE =
            "Available operations: +, -, *, /. "
                    + "Type \"exit\" to finish. "
                    + "Use a dot for decimal numbers.";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println(
                    "[SERVER] Started on port " + SERVER_PORT + "."
            );

            Calculator calculator = new Calculator();

            while (true) {
                Socket clientSocket = serverSocket.accept();

                try (clientSocket) {
                    System.out.println(
                            "[SERVER] Client connected: "
                                    + clientSocket.getRemoteSocketAddress()
                    );

                    handleClient(clientSocket, calculator);
                } catch (IOException e) {
                    System.err.println(
                            "[SERVER] Client communication error: "
                                    + e.getMessage()
                    );
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println(
                    "[SERVER] Server error: " + e.getMessage()
            );
            e.printStackTrace();
        }
    }

    private static void handleClient(
            Socket clientSocket,
            Calculator calculator
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
            sendMessage(bufferedWriter, AVAILABLE_OPERATIONS_MESSAGE);
            System.out.println(
                    "[SERVER] Available operations sent to client."
            );

            while (true) {
                String requestMessage = bufferedReader.readLine();

                if (requestMessage == null) {
                    System.out.println("[SERVER] Client disconnected.");
                    return;
                }

                if (EXIT_COMMAND.equalsIgnoreCase(requestMessage.strip())) {
                    System.out.println("[SERVER] Client session finished.");
                    return;
                }

                System.out.println(
                        "[SERVER] Request received: " + requestMessage
                );

                String response = processRequest(
                        requestMessage,
                        calculator
                );

                sendMessage(bufferedWriter, response);
                System.out.println(
                        "[SERVER] Response sent: " + response
                );
            }
        }
    }

    private static String processRequest(
            String requestMessage,
            Calculator calculator
    ) {
        String[] parts = requestMessage.split(
                REQUEST_DELIMITER,
                -1
        );

        if (parts.length != 3) {
            return "Error: invalid request format.";
        }

        try {
            double leftOperand = Double.parseDouble(parts[0].strip());
            String operation = parts[1].strip();
            double rightOperand = Double.parseDouble(parts[2].strip());

            double result = calculator.calculate(
                    leftOperand,
                    rightOperand,
                    operation
            );

            return "Result: " + result;
        } catch (NumberFormatException e) {
            return "Error: invalid number format.";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
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
