package com.streams;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class RefacoryCodeStreamProcessingDemo {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.txt";
        String outputFile = "src/main/resources/output.txt";
        String keyword = "keyword"; // The keyword to search for

        // Reading from the input file and writing to the output file
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process data: search for lines that contain the keyword
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


