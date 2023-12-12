package edu.ntnu.stud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.ntnu.stud.entity.Clock;
import edu.ntnu.stud.entity.Train;
import edu.ntnu.stud.logic.TrainRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** This class is used to test the TrainRegister class. */
public class TrainRegisterTest {
  private TrainRegister trainRegister;
  private Train train;
  private edu.ntnu.stud.entity.Clock clock;

  /** Initialize the trainRegister object before each test. */
  @BeforeEach
  void init() {
    this.trainRegister = new TrainRegister();
    this.clock = new Clock();
    this.clock.setTime("13:00");
  }

  /** Removes all trains from the trainRegister after each test. */
  @AfterEach
  void tearDown() {
    this.trainRegister = null;
    this.clock = null;
  }

  /** Test that the addTrains method returns true when adding a valid train. */
  @Test
  void testAddTrainsWithValidInput() {
    Train train = new Train("123", "A1", "Oslo", "12:00", 1);
    boolean expected = true;
    boolean actual = trainRegister.addTrains(train);
    assertEquals(expected, actual);
  }

  /** Test that the removeTrain method returns true when removing a valid train. */
  @Test
  void testRemoveTrainWithValidInput() {
    Train train = new Train("123", "A1", "Oslo", "12:00", 1);
    trainRegister.addTrains(train);
    boolean expected = true;
    boolean actual = trainRegister.removeTrain("123");
    assertEquals(expected, actual);
  }

  /**
   * Test that the deleteTrainAfterTime method returns true when deleting a train after a given
   * time.
   */
  @Test
  void testDeleteTrainAfterTimeWithValidInput() {
    boolean expected = true;
    boolean actual;
    this.trainRegister.deleteTrainAfterTime(this.trainRegister.getTrainRegister(), this.clock);
    actual = this.trainRegister.getTrainRegister().isEmpty();
    assertEquals(expected, actual);
  }

  /** Test that the getTrainRegister method returns true when getting the train register. */
  @Test
  void testGetTrainRegisterWithValidInput() {
    boolean expected = true;
    boolean actual;
    actual = this.trainRegister.getTrainRegister().isEmpty();
    assertEquals(expected, actual);
  }

  /** Test that the sortTrainsByDepartureTime sorts the trains by departure time. */
  @Test
  void testSortTrainsByDepartureTimeWithValidInput() {
    Train train = new Train("123", "A1", "Oslo", "12:00", 1);
    Train train2 = new Train("124", "A1", "Oslo", "13:00", 1);
    trainRegister.addTrains(train2);
    trainRegister.addTrains(train);
    boolean expected = true;
    boolean actual;
    actual =
        this.trainRegister.sortTrainsByDepartureTime().get(0).getDepartureTime().equals("12:00");
    assertEquals(expected, actual);
  }
}
