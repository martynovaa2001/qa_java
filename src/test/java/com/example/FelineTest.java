package com.example;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;

public class FelineTest {
    private final Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParam() {
        assertEquals(5, feline.getKittens(5));
    }
}
