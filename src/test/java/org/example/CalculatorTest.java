package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        int actual = Calculator.add(5, 8);
        int expected = 13;

        assertEquals(expected, actual);
    }
}