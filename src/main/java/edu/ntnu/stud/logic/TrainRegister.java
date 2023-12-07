package edu.ntnu.stud.logic;

import edu.ntnu.stud.entity.Clock;
import edu.ntnu.stud.entity.Departures;
import edu.ntnu.stud.entity.Train;
import java.util.HashMap;

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
  private final Clock trainClock;
  private Train train;
  private Departures departures;

  public TrainRegister() {
    this.trains = new HashMap<>();
    this.trainClock = new Clock();
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
   * Removes the train from the trainRegister if the train is behind the current time.
   *
   * @param train contains the train number, departure line, destination and departure time.
   * @return TODO:Should not think about the time and only delete.
   */
  public boolean removeTrains(Train train) {
    if (this.trains.containsKey(train.getTrainNumber())) {
      if (this.trainClock.getTime().compareTo(train.getDepartureTime()) > 0) {
        this.trains.remove(train.getTrainNumber());
        return true;
      }
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
    this.addTrains(new Train("125", "A1", "Oslo", "11:30", 1));
    this.addTrains(new Train("126", "A1", "Oslo", "12:00", 1));
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
   */
  public void departure(String trainNumber, String delay) {
    for (Train train : this.trains.values()) {
      if (train.getTrainNumber().equals(trainNumber)) {
        this.departures = new Departures(delay, train.getDepartureTime(), train);
        // System.out.println(train.trainToString());
      }
    }
  }

  /**
   * Returns the train by the given destination.
   *
   * @param destination the destination.
   */
  public Train getTrainByDestination(String destination) {
    for (Train train : this.trains.values()) {
      if (train.getDestination().equals(destination)) {
        return train;
      }
    }
    return null;
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
