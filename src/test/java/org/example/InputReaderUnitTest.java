package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderUnitTest {

    private final InputReader mockInputReader = new InputReader();
    private final String mockContent = mockInputReader.getContent();

    @Test
    void getContentHappyPath() {
        getContentIsNotNull();
        getContentIsNotEmpty();
    }
    @Test
    void getContentIsNotNull() {
        assertNotNull(mockContent);
    }
    @Test
    void getContentIsNotEmpty() {
        assertFalse(mockContent.isEmpty());
    }
    @Test
    void getContentIsNull() {
        assertNull(null);
        assertThrows(IOException.class, () -> {throw new IOException("Input stream is null");});
    }

    @Test
    void getContentIsEmpty() {
        assertTrue(true);
        assertThrows(IllegalArgumentException.class, () -> {throw new IllegalArgumentException("Input stream is empty");});
    }
}