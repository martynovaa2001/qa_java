package com.example;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionMockTest {
    private Feline mockFeline;

    @Before
    public void setUp() throws Exception {
        mockFeline = mock(Feline.class);
    }

    @Test
    public void testLionConstructorMale() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorFemale() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void testLionConstructorWrongSex() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Несуществующий пол", mockFeline);
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

 }