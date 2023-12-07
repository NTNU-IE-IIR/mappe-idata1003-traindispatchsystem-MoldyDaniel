package edu.ntnu.stud.entity;

/**
 * The Train class is used to store information about the trains.
 * The class will store information about the train number,
 * departure line, destination, departure time and track.
 */
public class Train {
  private String trainNumber;
  private String departureLine;
  private String destination;
  private String departureTime;
  private int track;

  /**
   * Create a new Instance of the Train object with the parameters given.
   *
   * @param trainNumber The train number. Must be a String with a unique number compared to other
   *     train numbers within the 24-hour period.
   * @param departureLine The departure line. Must be a string which starts with a single capital
   *     letter and ends with up with a minimum of 1 whole number and a maximum of 2 whole numbers.
   * @param destination The destination. Must be a string.
   * @param departureTime The departure time. Must be withing the "tt:mm" format for the localtime
   *     class with 24 hour showing. If departure time is invalid, the departure time will be set to
   *     "00:00".
   * @param track The track number. A whole number. If track is 0 or less, the track will be set to
   *     -1.
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
    this.setTrack(track);
  }

  /**
   * Returns a string representation of the train object.
   *
   * @return a string representation of the train object. TODO: Might remove this function because
   *     strings should be in the ui class.
   */
  public String trainToString() {
    return "Train number: "
        + this.trainNumber
        + "\n"
        + "Departure Line: "
        + this.departureLine
        + "\n"
        + "Destination: "
        + this.destination
        + "\n"
        + "Departure time: "
        + this.departureTime
        + "\n"
        + "Track: "
        + this.track;
  }

  /**
   * Returns the train number.
   *
   * @return the train number
   */
  public String getTrainNumber() {
    return trainNumber;
  }

  /**
   * Sets the train number.
   *
   * @param trainNumber the train number to set
   */
  public void setTrainNumber(String trainNumber) {
    boolean isInvalid = false;
    String[] number = trainNumber.split("");
    String tempTrainNumber = "";
    for (int i = 0; i < number.length; i++) {
      // checks if the string is a number or a capital letters, symbols are not allowed.
      if (number[i].matches("[0-9]")) {
        tempTrainNumber += number[i];
      } else {
        isInvalid = true;
      }
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
   * Sets the departure line. Departure times in norway are limited to a length of 4 in norway and
   * always start with a capital letter and end with a number.
   *
   * @param departureLine the departure line to set
   */
  public void setDepartureLine(String departureLine) {

    if (departureLine.length() < 2 || departureLine.length() > 4) {
      this.departureLine = "INVALID";
    } else {
      String[] line = departureLine.split("");
      if ((line[0].matches("[A-Z]")) && (line[line.length - 1].matches("[0-9]"))) {
        this.departureLine = departureLine;
      } else {
        this.departureLine = "INVALID";
      }
    }
  }

  /**
   * Returns the destination.
   *
   * @return the destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Sets the destination.
   *
   * @param destination the destination to set
   */
  public void setDestination(String destination) {
    if (destination == null || destination.isBlank()) {
      this.destination = "INVALID";
    } else {
      this.destination = destination;
    }
  }

  /**
   * Returns the departure time.
   *
   * @return the departure time
   */
  public String getDepartureTime() {
    return departureTime;
  }

  /**
   * Sets the departure time.
   *
   * @param departureTime the departure time to set TODO:"La localtime klassen ta seg av dette"
   */
  public void setDepartureTime(String departureTime) {
    if ((departureTime.length() != 5) && (departureTime.charAt(3) != ':')) {
      this.departureTime = "00:00";
    } else {
      String[] time = departureTime.split(":");

      if (time.length != 2) {
        this.departureTime = "00:00";
      } else {
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
          this.departureTime = "00:00";
        } else {
          this.departureTime = departureTime;
        }
      }
    }
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
   * @param track the track to set
   */
  public void setTrack(int track) {
    if (track <= 0) {
      this.track = -1;
    } else {
      this.track = track;
    }
  }
}
