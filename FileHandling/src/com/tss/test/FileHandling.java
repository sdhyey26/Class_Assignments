package com.tss.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) {
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try {
            FileReader reader = new FileReader("learn.txt");
            FileWriter writer = new FileWriter("output.txt");

            int ch;
            boolean inWord = false;

            while ((ch = reader.read()) != -1) {
                char current = (char) ch;

                System.out.print(current);

                writer.write(current);

                charCount++;

                if (current == '\n') {
                    lineCount++;
                }

                if (Character.isWhitespace(current)) {
                    inWord = false;
                } else if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            }

            reader.close();
            writer.close();

            System.out.println("\nCharacters: " + charCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Lines: " + (lineCount + 1)); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
