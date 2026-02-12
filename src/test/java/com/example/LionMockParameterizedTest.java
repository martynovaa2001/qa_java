package com.example;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class LionMockParameterizedTest {
    private Lion lion;
    private Feline mockFeline;
    private String sex;
    private int kittensCount;

    @Parameterized.Parameters(name = "sex={0}, kittensCount={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", 5},
                {"Самка", 7}
        });
    }

    public LionMockParameterizedTest (String sex, int kittensCount){
        this.sex = sex;
        this.kittensCount = kittensCount;
    }

    @Before
    public void setUp() throws Exception {
        mockFeline = mock(Feline.class);
        lion = new Lion(sex, mockFeline);
    }

    @Test
    public void testGetFoodUsesFelineMock() throws Exception {
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Антилопа"));
        List<String> food = lion.getFood();
        assertEquals(List.of("Антилопа"), food);
    }

    @Test
    public void testGetKittensUsesFelineMock() throws Exception {
        when(mockFeline.getKittens()).thenReturn(kittensCount);
        int kittens = lion.getKittens();
        assertEquals(kittensCount, kittens);
    }

    @Test
    public void testGetFoodEmptyFromMockedPredator() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of());
        List<String> food = lion.getFood();
        assertTrue(food.isEmpty());
    }

}