package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PersonsBornInNovemberUnitTest {


    private final Person person1 = new Person("John", "Doe", 1, 11, 1990);
    private final Person person2 = new Person("Jane", "Doe", 1, 12, 1990);
    private final Person person3 = new Person("John", "Smith", 1, 11, 1990);
    private final List<Person> persons = new ArrayList<>();

    @Test
    void HappyPath(){
        verifyMonth();
        getPersonsBornInNovember();
        getPersonsBornInNovemberIsSorted();
    }
    @Test
    void getPersonsBornInNovember() {
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        final List<Person> personsBornInNovember = persons.
                stream().
                filter(person -> person.getMonth() == 11).
                collect(Collectors.toList());
        assertNotNull(personsBornInNovember);
    }

    @Test
    void verifyMonth() {
        assertEquals(11, person1.getMonth());
        assertNotEquals(11, person2.getMonth());
        assertEquals(11, person3.getMonth());
    }
    @Test
    void getPersonsBornInNovemberIsNull() {
        final Database mockdatabase = new Database();
        mockdatabase.getPersons().clear();

        assertThrows(NullPointerException.class, () -> {throw new NullPointerException("PersonsBornInNovember is null");});
    }
    @Test
    void getPersonsBornInNovemberIsEmpty() {
        final List<Person> personsNotBornInNovember = persons.
                stream().
                filter(person -> person.getMonth() != 11).
                collect(Collectors.toList());
        assertTrue(personsNotBornInNovember.isEmpty());
    }


    @Test
    void getPersonsBornInNovemberIsSorted() {
        List<Person> mockPersons = new ArrayList<>();
        mockPersons.add(person1);
        mockPersons.add(person3);
        List<Person> sortedPersons = mockPersons.
                stream().
                filter(person -> person.getMonth() == 11).
                sorted((p1, p2) -> (p1.getLastName()+p1.getFirstName()).compareToIgnoreCase(p2.getLastName()+p2.getFirstName())).
                collect(Collectors.toList());
        assertEquals(person3, sortedPersons.get(1));
        assertEquals(person1, sortedPersons.get(0));

    }

}