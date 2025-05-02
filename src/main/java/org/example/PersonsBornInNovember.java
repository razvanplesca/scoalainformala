package org.example;

import java.util.List;
import java.util.stream.Collectors;

class PersonsBornInNovember {
    private final Database database = new Database();
    List<Person> getPersonsBornInNovember() {
        return database.getPersons().
                stream().
                filter(person -> person.getMonth() == 11).
                sorted((p1, p2) -> (p1.getLastName()+p1.getFirstName()).compareToIgnoreCase(p2.getLastName()+p2.getFirstName())).
                collect(Collectors.toList());
    }
}
