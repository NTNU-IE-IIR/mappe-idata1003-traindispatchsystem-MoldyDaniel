package edu.ntnu.stud.entity;

import java.time.LocalTime;

/**
 * The Train class represents information related to trains, encompassing details such as train
 * number, departure line, destination, departure time, delay, and track number.
 *
 * <p>This class enables users to:
 *
 * <ul>
 *   <li>Retrieve train number.
 *   <li>Set and validate train numbers ensuring only numeric characters are used.
 *   <li>Access and validate the departure line according to specific format requirements.
 *   <li>Manage destination information, ensuring it's a non-empty string.
 *   <li>Handle and validate departure time, setting it in "HH:mm" format or defaulting to "00:00"
 *       if invalid.
 *   <li>Manage and validate delay information, ensuring it follows time format or defaulting to
 *       "00:00" if invalid.
 *   <li>Handle track number, ensuring it is a positive integer or setting it to -1 if invalid.
 * </ul>
 *
 * @author Daniel
 * @version 2023-12-12
 */
public class Train {
  private String trainNumber;
  private String departureLine;
  private String destination;
  private String departureTime;
  private String delay = "00:00";
  private int track;

  /**
   * Creates a new instance of the Train object with the given parameters.
   *
   * @param trainNumber The train number. Must be a unique string compared to other train numbers
   *     within a 24-hour period.
   * @param departureLine The departure line. Format: A single capital letter followed by 1 to 2
   *     whole numbers.
   * @param destination The destination. Must be a non-empty string.
   * @param departureTime The departure time in "HH:mm" format (24-hour clock). If invalid, set to
   *     "00:00".
   * @param track The track number. Must be a positive whole number. If 0 or less, set to -1.
   */
  public Train(
      String trainNumber,
      String departureLine,
      String destination,
      String departureTime,
      int track) {
    this.setTrainNumber(trainNumber);
    this.setDepartureLine(departureLine);
    this.setDestination(destination);
    this.setDepartureTime(departureTime);
    this.setDelay(delay);
    this.setTrack(track);
  }

  /**
   * Returns the train number.
   *
   * @return The train number.
   */
  public String getTrainNumber() {
    return trainNumber;
  }

  /**
   * Sets the train number.
   *
   * @param trainNumber The train number to set. It should contain only numbers. If it contains
   *     other characters, set to {@code "INVALID"}.
   */
  public void setTrainNumber(String trainNumber) {
    boolean isInvalid = false;
    String[] number = trainNumber.split("");
    String tempTrainNumber = "";
    for (int i = 0; i < number.length; i++) {
      // checks if the string is a number or a capital letters, symbols are not allowed.
      // Guard condition
      if (number[i].matches("[0-9]")) {
        tempTrainNumber += number[i];
      } else {
        isInvalid = true;
      }
      // End of Guard condition
    }
    if (isInvalid) {
      this.trainNumber = "INVALID";
    } else {
      this.trainNumber = tempTrainNumber;
    }
  }

  /**
   * Returns the departure line.
   *
   * @return the departure line
   */
  public String getDepartureLine() {
    return departureLine;
  }

  /**
   * Sets the departure line.
   *
   * @param departureLine The departure line to set. Must start with a capital letter and end with a
   *     number. If not in this format, set to {@code "INVALID"}.
   */
  public void setDepartureLine(String departureLine) {
    // Guard condition
    if (departureLine.length() < 2 || departureLine.length() > 4) {
      this.departureLine = "INVALID";
      // End of Guard condition
    } else {
      String[] line = departureLine.split("");
      // Guard condition
      if ((line[0].matches("[A-Z]")) && (line[line.length - 1].matches("[0-9]"))) {
        this.departureLine = departureLine;
      } else {
        this.departureLine = "INVALID";
      }
      // End of Guard condition
    }
  }

  /**
   * Returns the destination.
   *
   * @return The destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Sets the destination.
   *
   * @param destination The destination to set. If null or blank, set to {@code "INVALID"}.
   */
  public void setDestination(String destination) {
    // Guard condition
    if (destination == null || destination.isBlank()) {
      this.destination = "INVALID";
    } else {
      this.destination = destination;
    }
    // End of Guard condition
  }

  /**
   * Returns the departure time.
   *
   * @return The departure time.
   */
  public String getDepartureTime() {
    return departureTime;
  }

  /**
   * Sets the departure time.
   *
   * @param departureTime The departure time to set. If invalid format, set to {@code "00:00"}.
   */
  public void setDepartureTime(String departureTime) {
    try {
      // Guard condition
      if ((LocalTime.parse(departureTime).equals(LocalTime.parse("00:00")))) {
        this.departureTime = "00:00";
      } else {
        this.departureTime = departureTime;
      }
    } catch (Exception dateTimeParseException) {
      this.departureTime = "00:00";
    }
    // End of Guard condition
  }

  /**
   * Returns the delay.
   *
   * @return the delay
   */
  public String getDelay() {
    return delay;
  }

  /**
   * Sets the delay.
   *
   * @param delay The delay to set. If invalid format, set to {@code "00:00"}.
   */
  public void setDelay(String delay) {
    try {
      // Guard condition
      if ((LocalTime.parse(delay).equals(LocalTime.parse("00:00")))) {
        this.delay = "00:00";
      } else {
        this.delay = delay;
      }
    } catch (Exception dateTimeParseException) {
      this.delay = "00:00";
    }
    // End of Guard condition
  }

  /**
   * Returns the track number.
   *
   * @return the track
   */
  public int getTrack() {
    return track;
  }

  /**
   * Sets the track number.
   *
   * @param track The track number to set. If less than or equal to 0, set to -1.
   */
  public void setTrack(int track) {
    // Guard condition
    if (track <= 0) {
      this.track = -1;
    } else {
      this.track = track;
    }
    // End of Guard condition
  }
}
