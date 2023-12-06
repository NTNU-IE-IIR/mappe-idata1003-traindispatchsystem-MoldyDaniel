package edu.ntnu.stud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockTest {

    private Clock Clock;
    private Clock time;

    /**
     * Reset the clock before each test.
     */
    @BeforeEach
    void init() {
        this.time = new Clock();
    }

    @Test
    void testGetTimeWithValidInput() {
        String expected = "00:00";
        String actual = time.getTime();
        assertEquals(expected, actual);
    }
    @Test
    void testGetHoursWithValidInput() {
        int expected = 0;
        int actual = time.getHours();
        assertEquals(expected, actual);
    }
    @Test
    void testGetMinutesWithValidInput() {
        int expected = 0;
        int actual = time.getMinutes();
        assertEquals(expected, actual);
    }
    @Test
    void testSetTimeWithInvalidInput() {
        time.setTime("01:01");
        String expected = "01:01";
        String actual = time.getTime();
        assertEquals(expected, actual);
    }
}
