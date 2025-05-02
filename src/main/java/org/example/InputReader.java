package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

class InputReader {
    String getContent() {
        String content = null;
        try {
            ClassLoader classLoader = InputReader.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("input.txt");

            assert inputStream != null;
            content = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining("\n"));

        } catch (Exception e) {
            throw new RuntimeException("Error reading the file: " + e.getMessage());
        }
        return content;
    }
}
