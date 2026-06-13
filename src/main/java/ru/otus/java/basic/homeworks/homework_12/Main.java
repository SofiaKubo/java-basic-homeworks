package ru.otus.java.basic.homeworks.homework_12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;

public class Main {
    private static final Path TEXT_FILES_DIRECTORY = Path.of(
            "src", "main", "java", "ru", "otus", "java", "basic", "homeworks", "homework_12"
    );

    public static void main(String[] args) {
        if (!Files.isDirectory(TEXT_FILES_DIRECTORY)) {
            System.out.println("Directory not found: " +
                    TEXT_FILES_DIRECTORY.toAbsolutePath());
            return;
        }

        List<Path> textFiles = getTextFiles(TEXT_FILES_DIRECTORY);

        if (textFiles.isEmpty()) {
            System.out.println("No text files found in the directory.");
            return;
        }

        System.out.println("Text files in the project are:");
        printFileNames(textFiles);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine().trim();

        if (fileName.isBlank()) {
            System.out.println("File name must not be empty.");
            return;
        }

        Path selectedFile = TEXT_FILES_DIRECTORY.resolve(fileName).normalize();

        if (!selectedFile.startsWith(TEXT_FILES_DIRECTORY.normalize())) {
            System.out.println("Only files from the homework directory are allowed.");
            return;
        }

        if (!Files.isRegularFile(selectedFile)) {
            System.out.println(
                    "File not found: " + selectedFile.toAbsolutePath());
            return;
        }

        if (!selectedFile.getFileName().toString().endsWith(".txt")) {
            System.out.println("Only .txt files are allowed.");
            return;
        }

        printFileContents(selectedFile);

        System.out.println("Enter a new line:");
        String textToWrite = scanner.nextLine();

        writeToFile(selectedFile, textToWrite);
        printFileContents(selectedFile);
    }

    private static List<Path> getTextFiles(Path directory) {
        File[] files = directory.toFile().listFiles();

        if (files == null) {
            System.out.println(
                    "Cannot read directory: " + directory.toAbsolutePath());
            return List.of();
        }

        List<Path> textFiles = new ArrayList<>();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                textFiles.add(file.toPath());
            }
        }

        return textFiles;
    }

    private static void printFileNames(List<Path> files) {
        for (Path file : files) {
            System.out.println(file.getFileName());
        }
    }

    private static void printFileContents(Path file) {
        System.out.println("File contents:");

        try (BufferedReader reader = Files.newBufferedReader(
                file,
                StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Cannot read file: " + file.toAbsolutePath());
        }
    }

    private static void writeToFile(Path file, String textToWrite) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                file,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            if (Files.size(file) > 0) {
                writer.newLine();
            }

            writer.write(textToWrite);
            writer.newLine();

            System.out.println("Line was successfully written to the file.");
        } catch (IOException e) {
            System.out.println(
                    "Cannot write to file: " + file.toAbsolutePath());
        }
    }
}