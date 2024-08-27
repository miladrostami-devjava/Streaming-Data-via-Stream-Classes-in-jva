package com.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class StreamProcessingDemo {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.txt";
        String outputFile = "src/main/resources/output.txt";
        String keyword = "keyword"; // The keyword to search for

        // Reading from the input file and writing to the output file
        try (
                InputStream inputStream = new FileInputStream(inputFile);
                BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
                OutputStream outputStream = new FileOutputStream(outputFile);
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Processing data: search for lines that contain the keyword
                if (line.contains(keyword)) {
                    // Write lines that contain the keyword to the output file
                    writer.write(line);
                    writer.newLine(); // Add a new line for each written line
                }
            }
            System.out.println("Processing completed successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

