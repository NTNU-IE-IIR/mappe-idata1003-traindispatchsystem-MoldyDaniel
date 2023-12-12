package edu.ntnu.stud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.ntnu.stud.entity.Clock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** This class is used to test the Clock class. */
public class ClockTest {

  /** Instance variable for the Clock class. */
  private Clock time;

  /** Reset the clock before each test. */
  @BeforeEach
  void init() {
    this.time = new Clock();
  }

  /** Test that the getTime method returns the correct time. */
  @Test
  void testGetTimeWithValidInput() {
    String expected = "00:00";
    String actual = time.getTime();
    assertEquals(expected, actual);
  }

  /** Test that the getHours method returns the correct time. */
  @Test
  void testGetHoursWithValidInput() {
    int expected = 0;
    int actual = time.getHours();
    assertEquals(expected, actual);
  }

  /** Test that the getMinutes method returns the correct time. */
  @Test
  void testGetMinutesWithValidInput() {
    int expected = 0;
    int actual = time.getMinutes();
    assertEquals(expected, actual);
  }

  /** Test that the setTime method returns the correct time. */
  @Test
  void testSetTimeWithValidInput() {
    time.setTime("01:01");
    String expected = "01:01";
    String actual = time.getTime();
    assertEquals(expected, actual);
  }

  @Test
  void testSetTimeWithInvalidInput() {
    time.setTime("01:011");
    assertEquals("00:00", time.getTime());
  }

  /** Test that the isBefore method works. */
  @Test
  void testIsBeforeWithValidInput() {
    boolean expected = true;
    boolean actual = time.isBefore("01:01", "01:02");
    assertEquals(expected, actual);
  }
}
