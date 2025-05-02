package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class OutputWriter {
    private final PersonsBornInNovember personsBornInNovember = new PersonsBornInNovember();
    String outputFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "output.txt";

    void print() {

        try (FileWriter file = new FileWriter(outputFilePath, StandardCharsets.UTF_8)) {
            file.write("Persons born in November in alphabetical order\n");
            personsBornInNovember.getPersonsBornInNovember().forEach(person -> {
                try {
                    file.write(person.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
