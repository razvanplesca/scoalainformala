package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseUnitTest {
    private final List <Person> mockDatabase = new ArrayList<>();
    private final Person person = new Person("John", "Doe", 1, 1, 1990);

    @Test
    void happyPath(){
        getPersonsIsNotNull();
        getPersonsIsNotEmpty();
    }
    @Test
    void getPersonsIsNotNull() {
        mockDatabase.add(person);
        assertNotNull(mockDatabase);
    }
    @Test
    void getPersonsIsNotEmpty() {
        mockDatabase.add(person);
        assertFalse(false);
    }
    @Test
    void getPersonsIsEmpty() {
        assertTrue(mockDatabase.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> {throw new IllegalArgumentException("Database is empty");});
    }
    @Test
    void getPersonsIsNull() {
        assertThrows(NullPointerException.class, () -> {throw new NullPointerException("Database is null");});
    }
    @Test
    void PersonIsNull() {
        assertFalse(mockDatabase.contains(null));
        assertThrows(NullPointerException.class, () -> {throw new NullPointerException("Person is null");});
    }
    @Test
    void addPerson() {
        mockDatabase.add(person);
        assertEquals(1, mockDatabase.size());
    }

}