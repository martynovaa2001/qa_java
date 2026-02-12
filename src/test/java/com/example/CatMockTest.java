package com.example;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class CatMockTest {
    private Cat cat;
    private Feline mockFeline;

    @Before
    public void setUp() {
        mockFeline = mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Мышь"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Мышь"), food);
    }
}