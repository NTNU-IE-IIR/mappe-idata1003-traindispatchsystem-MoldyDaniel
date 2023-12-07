package edu.ntnu.stud.entity;

import java.time.LocalTime;

/** Use LocalTime to represent the current time in hours and minutes. */
public class Clock {
  /** Instance variable for the time. */
  private LocalTime time;

  /** Create a new Clock object with the time set to 00:00. */
  public Clock() {
    time = LocalTime.MIN;
  }

  /**
   * Returns the current hour of the day.
   *
   * @return the current hour of the day
   */
  public int getHours() {
    return this.time.getHour();
  }

  /**
   * Returns the current minute of the hour.
   *
   * @return the current minute of the hour
   */
  public int getMinutes() {
    return this.time.getMinute();
  }

  /**
   * Returns the current time as a string in the format "hh:mm".
   *
   * @return the current time as a string in the format "hh:mm"
   */
  public String getTime() {
    return this.time.toString();
  }
  /**
   * Sets the time to the given time as long as it is after the already set time.
   *
   * @param inputTime the time to set the clock to.
   * @return returns true if the time was set, false if not.
   */

  public boolean setTime(String inputTime) {
    boolean result;
    try {
      if (this.time.isBefore(LocalTime.parse(inputTime))) {
        this.time = LocalTime.parse(inputTime);
        result = true;
      } else {
        result = false;
      }
    } catch (Exception dateTimeParseException) {
      result = false;
    }
    return result;
  }

  /**
   * Checks if the first time is before the second time.
   *
   * @param first the first time to check.
   * @param second the second time to check.
   * @return returns true if the first time is before the second time, false if not.
   */
  public boolean isBefore(String first, String second) {
    boolean result;
    result = LocalTime.parse(first).isBefore(LocalTime.parse(second));
    return result;
  }
}
