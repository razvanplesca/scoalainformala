package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Database {
    List<Person> getPersons() {
        String[] lines = new InputReader().getContent().split("\n");

        return  Stream.of(lines).
                map(line -> {
                    String[] data = line.split(" ");
                    return new Person(data[0],
                            data[1],
                            Integer.parseInt(data[2].substring(0,2)),
                            Integer.parseInt(data[2].substring(3,5)),
                            Integer.parseInt(data[2].substring(6 )));}).
                collect(Collectors.toList());
    }
}
