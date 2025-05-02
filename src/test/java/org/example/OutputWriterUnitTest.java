package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OutputWriterUnitTest {
    final OutputWriter mockOutputWriter = new OutputWriter();
    final Person person1 = new Person("John", "Doe", 1, 1, 1990);
    final Person person2 = new Person("Jane", "Doe", 1, 11, 1990);

    @Test
    void happyPath(){
        outputFilePathIsNotNull();
        listOfPersonsBornInNovemberIsNotNull();
        printPersonsBornInNovember();
    }
    @Test
    void outputFilePathIsNotNull() {
        assertDoesNotThrow(mockOutputWriter::print);
    }
    @Test
    void outputFilePathIsNull() {
        mockOutputWriter.outputFilePath = null;
        assertThrows(NullPointerException.class, () -> {throw new NullPointerException("OutputWriter File Path does not exist");});
    }

    @Test
    void printPersonsBornInNovember() {

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        String personsBornInNovember = persons.
                stream().
                filter(person -> person.getMonth() == 11).
                map(Person::toString).
                sorted()
                .collect(Collectors.joining("\n"));
        assertEquals(personsBornInNovember,person2.toString());
    }
    @Test
    void listOfPersonsBornInNovemberIsNull(){
        final PersonsBornInNovember mockPersons = new PersonsBornInNovember();
        mockPersons.getPersonsBornInNovember().clear();
        assertThrows(NullPointerException.class, () -> {throw new NullPointerException("PersonsBornInNovember is null");});
    }
    @Test
    void listOfPersonsBornInNovemberIsNotNull(){
        final PersonsBornInNovember mockPersons = new PersonsBornInNovember();
        mockPersons.getPersonsBornInNovember().add(person2);
        assertDoesNotThrow(mockPersons::getPersonsBornInNovember);

    }
}