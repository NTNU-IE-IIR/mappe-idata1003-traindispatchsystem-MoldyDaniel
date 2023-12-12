package edu.ntnu.stud.logic;

import edu.ntnu.stud.entity.Clock;
import edu.ntnu.stud.entity.Train;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The TrainRegister class manages the registration, removal, and various operations related to
 * trains. It provides functionality for adding and removing trains from the register and includes
 * methods to delay train departures. Additionally, it offers methods to retrieve trains based on
 * their destination or train number.
 *
 * <p><strong>Functionalities:</strong>
 *
 * <ul>
 *   <li>Registering and removing trains
 *   <li>Delaying train departures
 *   <li>Retrieving trains by destination or train number
 * </ul>
 *
 * <p><strong>Operations:</strong>
 *
 * <ul>
 *   <li>{@link #addTrains(Train)}: Adds a train to the register if valid
 *   <li>{@link #removeTrain(String)}: Removes a train from the register by train number
 *   <li>{@link #getTrainRegister()}: Retrieves the entire train register
 *   <li>{@link #deleteTrainAfterTime(HashMap, Clock)}: Deletes trains with past departure times
 *   <li>{@link #getTrainsByDestination(String)}: Retrieves trains by their destination
 *   <li>{@link #sortTrainsByDepartureTime()}: Sorts trains in the register by departure time
 *   <li>{@link #getTrainByTrainNumber(String)}: Retrieves a train by its train number
 * </ul>
 */
public class TrainRegister {
  private final HashMap<String, Train> trains;
  private final Clock clock = new Clock();
  private final ArrayList<String> trainNumbers = new ArrayList<>();

  /** Create a new instance of the TrainRegister object. */
  public TrainRegister() {
    this.trains = new HashMap<>();
  }

  /**
   * Adds the train to the trainRegister if the train number is unique and the departure line,
   * destination, and departure time are valid.
   *
   * @param train Contains the train number, departure line, destination, and departure time.
   * @return {@code true} if the Train was added successfully, {@code false} otherwise.
   */
  public boolean addTrains(Train train) {
    if (this.trainNumbers.contains(train.getTrainNumber())
        || train.getTrainNumber().equals("INVALID")) {
      return false;
    }
    if (train.getDepartureLine().equals("INVALID")
        || train.getDestination().equals("INVALID")
        || train.getDepartureTime().equals("INVALID")) {
      return false;
    } else {
      trainNumbers.add(train.getTrainNumber());
      this.trains.put(train.getTrainNumber(), train);
      return true;
    }
  }

  /**
   * Removes the train from the trainRegister if the train number is in the trainRegister.
   *
   * @param trainNumber The train number.
   * @return True if the train is removed from the trainRegister.
   */
  public boolean removeTrain(String trainNumber) {
    boolean result;
    if (this.trains.containsKey(trainNumber)) {
      this.trains.remove(trainNumber);
      result = true;
    } else {
      result = false;
    }
    return result;
  }



  /**
   * Returns the trainRegister.
   *
   * @return The trainRegister.
   */
  public HashMap<String, Train> getTrainRegister() {
    return trains;
  }

  /**
   * GitHub Copilot was used to help generate this method after
   * I made some simple code and knew what I wanted to do.
   * Deletes trains from the trainRegister that have departure times before the current time.
   *
   * @param trainRegister The HashMap of trains registered.
   * @param clock The Clock object representing current time.
   */
  public void deleteTrainAfterTime(HashMap<String, Train> trainRegister, Clock clock) {
    ArrayList<String> selectedTrainNumber = new ArrayList<>();
    for (Train train : trainRegister.values()) {
      if (clock.isBefore(train.getDepartureTime(), clock.getTime())) {
        selectedTrainNumber.add(train.getTrainNumber());
      }
    }
    for (String trainNumber : selectedTrainNumber) {
      trainRegister.remove(trainNumber);
    }
  }

  /**
   * Returns a list of trains that have the specified destination.
   *
   * @param destination The destination to search for.
   * @return An ArrayList of trains with the specified destination.
   */
  public ArrayList<Train> getTrainsByDestination(String destination) {
    ArrayList<Train> trains = new ArrayList<>();
    for (Train train : this.trains.values()) {
      if (train.getDestination().equals(destination)) {
        trains.add(train);
      }
    }
    return trains;
  }

  /**
   * GitHub Copilot was used to help generate this method after
   * I made some simple code and knew what I wanted to do.
   * Sorts the trains in the trainRegister by their departure time.
   *
   * @return An ArrayList of trains sorted by departure time.
   */
  public ArrayList<Train> sortTrainsByDepartureTime() {

    ArrayList<Train> trains = new ArrayList<>(this.trains.values());
    trains.sort(
        (train1, train2) -> {
          String departureTime1 =
              train1.getDepartureTime(); // Get departure time as string for train1
          String departureTime2 =
              train2.getDepartureTime(); // Get departure time as string for train2
          int result;
          if (this.clock.isBefore(departureTime1, departureTime2)) {
            result = -1; // train1 comes before train2
          } else if (this.clock.isBefore(departureTime2, departureTime1)) {
            result = 1; // train2 comes before train1
          } else {
            result = 0;
          }
          return result; // departure times are the same
        });
    return trains;
  }

  /**
   * Retrieves a train by its train number.
   *
   * @param trainNumber The train number to search for.
   * @return The train associated with the specified train number, or null if not found.
   */
  public Train getTrainByTrainNumber(String trainNumber) {
    for (Train train : this.trains.values()) {
      if (train.getTrainNumber().equals(trainNumber)) {
        return train;
      }
    }
    return null;
  }
}
