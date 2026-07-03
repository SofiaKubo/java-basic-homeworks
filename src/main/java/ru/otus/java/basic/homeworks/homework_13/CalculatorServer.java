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
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class CalculatorServer {
    private static final String SERVER_LOG_PREFIX = "[SERVER] ";
    private static final int SERVER_PORT = 8091;
    private static final String EXIT_COMMAND = "exit";
    private static final String REQUEST_DELIMITER = ";";
    private static final String AVAILABLE_OPERATIONS_MESSAGE =
            "Available operations: +, -, *, /. "
                    + "Type \"exit\" to finish. "
                    + "Use a dot for decimal numbers.";

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServer.class);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            logger.info("{}Started on port {}.", SERVER_LOG_PREFIX, SERVER_PORT);

            Calculator calculator = new Calculator();

            while (true) {
                Socket clientSocket = serverSocket.accept();

                try (clientSocket) {
                    logger.info(
                            "{}Client connected: {}",
                            SERVER_LOG_PREFIX,
                            clientSocket.getRemoteSocketAddress()
                    );

                    handleClient(clientSocket, calculator);
                } catch (IOException e) {
                    logger.error(
                            "{}Client communication error: {}",
                            SERVER_LOG_PREFIX,
                            e.getMessage(),
                            e
                    );
                }
            }
        } catch (IOException e) {
            logger.error(
                    "{}Server error: {}",
                    SERVER_LOG_PREFIX,
                    e.getMessage(),
                    e
            );
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
            logger.info("{}Available operations sent to client.", SERVER_LOG_PREFIX);

            while (true) {
                String requestMessage = bufferedReader.readLine();

                if (requestMessage == null) {
                    logger.info("{}Client disconnected.", SERVER_LOG_PREFIX);
                    return;
                }

                if (EXIT_COMMAND.equalsIgnoreCase(requestMessage.strip())) {
                    logger.info("{}Client session finished.", SERVER_LOG_PREFIX);
                    return;
                }

                logger.info(
                        "{}Request received: {}",
                        SERVER_LOG_PREFIX,
                        requestMessage
                );

                String response;
                try {
                    response = processRequest(requestMessage, calculator);
                } catch (Exception e) {
                    response = "Error: internal server error.";
                    logger.error(
                            "{}An internal error occurred while processing request: {}",
                            SERVER_LOG_PREFIX,
                            requestMessage,
                            e
                    );
                }

                sendMessage(bufferedWriter, response);
                logger.info(
                        "{}Response sent: {}",
                        SERVER_LOG_PREFIX,
                        response
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
