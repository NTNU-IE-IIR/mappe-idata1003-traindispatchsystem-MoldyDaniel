package edu.ntnu.stud.logic;

import edu.ntnu.stud.entity.Clock;
import edu.ntnu.stud.entity.Train;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.*;
import java.util.stream.Collectors;



/**
 * This class is used to register trains and remove trains from the trainRegister. It also contains
 * the departure method that delays the train by the given amount of minutes.
 *
 * <p>It also contains the getTrainByDestination and getTrainByTrainNumber methods that returns the
 * train by the given destination or train number.
 *
 */
public class TrainRegister {
  private final HashMap<String, Train> trains;
  private Train train;
  private Clock clock = new Clock();


  public TrainRegister() {
    this.trains = new HashMap<>();
  }

  /**
   * Adds the train to the trainRegister if the train number is unique and the departure line,
   * destination and departure time is valid.
   *
   * @param train contains the train number, departure line, destination and departure time.
   * @return true if the train is added to the trainRegister.
   */
  public boolean addTrains(Train train) {
    if (this.trains.containsKey(train.getTrainNumber())
        || train.getTrainNumber().equals("INVALID")) {
      return false;
    }
    if (train.getDepartureLine().equals("INVALID")
        || train.getDestination().equals("INVALID")
        || train.getDepartureTime().equals("INVALID")) {
      return false;
    } else {
      this.trains.put(train.getTrainNumber(), train);
      return true;
    }
  }

  /**
   * Removes the train from the trainRegister if the train number is in the trainRegister.
   *
   * @param trainNumber the train number.
   * @return true if the train is removed from the trainRegister.
   */
  public boolean removeTrain(String trainNumber) {
    if (this.trains.containsKey(trainNumber)) {
      this.trains.remove(trainNumber);
      return true;
    }
    return false;
  }

  /**
   * Fills the trainRegister with trains.
   *
   * <p>TODO: Remove this method when the UI is implemented.
   */
  public void fillTrainRegister() {
    this.addTrains(new Train("123", "A1", "Oslo", "11:00", 1));
    this.addTrains(new Train("124", "A1", "Oslo", "13:20", 1));
    this.addTrains(new Train("125", "A1", "Bergen", "11:30", 1));
    this.addTrains(new Train("126", "A1", "Bergen", "12:00", 1));
  }

  /**
   * Returns the trainRegister.
   *
   * @return the trainRegister.
   */
  public HashMap<String, Train> getTrainRegister() {
    return trains;
  }

  /**
   * Delays the train by the given amount of minutes using the Departures class. And the setDelay
   * method in the Departures class.
   *
   * @param trainNumber the train number.
   * TODO: Remove the departure method when the UI is implemented.
   */
  /**public void departure(String trainNumber, String delay) {
    for (Train train : this.trains.values()) {
      if (train.getTrainNumber().equals(trainNumber)) {
        this.departures = new Departures(delay, train);
        // System.out.println(train.trainToString());
      }
    }
  }*/

  /**
   * Returns the train by the given destination.
   *
   * @param destination the destination.
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
   * Sorts the trains by departure time.
   */
  public ArrayList<Train> sortTrainsByDepartureTime() {
    ArrayList<Train> trains = new ArrayList<>(this.trains.values());
    trains.sort((train1, train2) -> {
      String departureTime1 = train1.getDepartureTime(); // Get departure time as string for train1
      String departureTime2 = train2.getDepartureTime(); // Get departure time as string for train2

      if (this.clock.isBefore(departureTime1, departureTime2)) {
        return -1; // train1 comes before train2
      } else if (this.clock.isBefore(departureTime2, departureTime1)) {
        return 1; // train2 comes before train1
      }
      return 0; // departure times are the same
    });
    return trains;
  }

  /**
   * Returns the train by the given train number.
   *
   * @param trainNumber the train number.
   * @return the train.
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
