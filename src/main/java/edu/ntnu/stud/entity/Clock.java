package edu.ntnu.stud.entity;

import java.time.LocalTime;

/**
 * The Clock class represents the current time in hours and minutes using the LocalTime class from
 * the Java Date and Time API. It provides various functionalities to interact with and manipulate
 * time-related information.
 *
 * <p>This class allows users to:
 *
 * <ul>
 *   <li>Retrieve the current hour of the day.
 *   <li>Get the current minute of the hour.
 *   <li>Obtain the current time in a "hh:mm" string format.
 *   <li>Calculate time by adding a delay to a specified departure time.
 *   <li>Set the time to a given value if it's after the current time.
 *   <li>Compare two times to check if one is before the other.
 * </ul>
 */
public class Clock {
  /** Instance variable for the time. */
  private LocalTime time;

  /** Creates a new Clock object with the time set to 00:00. */
  public Clock() {
    time = LocalTime.MIN;
  }

  /**
   * Returns the current hour of the day.
   *
   * @return The current hour of the day.
   */
  public int getHours() {
    return this.time.getHour();
  }

  /**
   * Returns the current minute of the hour.
   *
   * @return The current minute of the hour
   */
  public int getMinutes() {
    return this.time.getMinute();
  }

  /**
   * Returns the current time as a string in the format "hh:mm".
   *
   * @return The current time as a string in the format "hh:mm"
   */
  public String getTime() {
    return this.time.toString();
  }

  /**
   * Calculates the time by adding departure time and delay.
   *
   * @param departureTime The departure time.
   * @param delay The delay to add to the departure time.
   * @return The result time after adding delay to departure time as a string.
   */
  public String getDelayPlusDepartureTime(String departureTime, String delay) {
    String result;
    LocalTime departure = LocalTime.parse(departureTime);
    LocalTime delayTime = LocalTime.parse(delay);
    LocalTime departurePlusDelay =
        departure.plusHours(delayTime.getHour()).plusMinutes(delayTime.getMinute());
    result = departurePlusDelay.toString();
    return result;
  }

  /**
   * Sets the time to the given time if it is after the current time.
   *
   * @param inputTime The time to set the clock to.
   * @return True if the time was set, false if not.
   */
  public boolean setTime(String inputTime) {
    boolean result;
    try {
      // Start of Guard condition
      if (this.time.isBefore(LocalTime.parse(inputTime))) {
        this.time = LocalTime.parse(inputTime);
        result = true;
      } else {
        result = false;
      }
      // End of Guard condition
    } catch (Exception dateTimeParseException) {
      // Catch invalid time format exceptions.
      result = false;
    }
    return result;
  }

  /**
   * Checks if the first time is before the second time.
   *
   * @param first The first time to check.
   * @param second The second time to check.
   * @return True if the first time is before the second time, false if not.
   */
  public boolean isBefore(String first, String second) {
    boolean result;
    result = LocalTime.parse(first).isBefore(LocalTime.parse(second));
    return result;
  }
}
