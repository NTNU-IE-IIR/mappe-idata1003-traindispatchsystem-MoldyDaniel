package edu.ntnu.stud;

import edu.ntnu.stud.logic.TrainRegister;
import edu.ntnu.stud.entity.Train;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/** This class is used to test the TrainRegister class. */
public class TrainRegisterTest {
    private TrainRegister trainRegister;
    private Train train;

    /** Initialize the trainRegister object before each test. */
    @BeforeEach
    void init() {
        this.trainRegister = new TrainRegister();
    }

    /** Removes all trains from the trainRegister after each test. */
    @AfterEach
    void tearDown() {
        this.trainRegister = null;
    }

    /** Test that the addTrains method returns true when adding a valid train. */
    @Test
    void testAddTrainsWithValidInput() {
        Train train = new Train("123", "A1", "Oslo", "12:00", 1);
        boolean expected = true;
        boolean actual = trainRegister.addTrains(train);
        assertEquals(expected, actual);
    }
}
