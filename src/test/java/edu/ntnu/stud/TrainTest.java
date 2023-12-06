package edu.ntnu.stud;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TrainTest {
    private TrainRegister trainRegister;
    private Train train;
    /**
     * Initialize the trainRegister object before each test.
     */
    @BeforeEach
    void init() {
        this.trainRegister = new TrainRegister();
        this.train = new Train("123", "A1", "Oslo", "12:00", 1);
    }

    /**
     * Removes all trains from the trainRegister after each test.
     */
    @AfterEach
    void tearDown() {
        this.trainRegister = null;
    }
    /**
     * Test that the trainToString method returns the correct string.
     */
    @Test
    void testTrainToStringWithValidInput() {

        String expected = "Train number: 123\n" +
                "Departure Line: A1\n" +
                "Destination: Oslo\n" +
                "Departure time: 12:00\n" +
                "Track: 1";
        String actual = train.trainToString();
        assertEquals(expected, actual);
    }
    /**
     * Test that the getTrainNumber method returns the correct train number.
     */
    @Test
    void testGetTrainNumberWithValidInput() {
        String expected = "123";
        String actual = train.getTrainNumber();
        assertEquals(expected, actual);
    }
    /**
     * Test that the getTrainNumber method returns the incorrect train number.
     */
    @Test
    void testGetDepartureLineWithValidInput() {
        String expected = "A1";
        String actual = train.getDepartureLine();
        assertEquals(expected, actual);
    }
    /**
     * Test that the getDestination method returns the correct destination.
     */
    @Test
    void testGetDestinationWithValidInput() {
        String expected = "Oslo";
        String actual = train.getDestination();
        assertEquals(expected, actual);
    }
    /**
     * Test that the getDepartureTime method returns the correct departure time.
     */
    @Test
    void testGetDepartureTimeWithValidInput() {
        String expected = "12:00";
        String actual = train.getDepartureTime();
        assertEquals(expected, actual);
    }

    /**
     * Test that the getTrack method returns the correct track number.
     */
    @Test
    void testGetTrackWithValidInput() {
        int expected = 1;
        int actual = train.getTrack();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setTrainNumber method sets the correct train number.
     */
    @Test
    void testSetTrainNumberWithValidInput() {
        String expected = "124";
        train.setTrainNumber("124");
        String actual = train.getTrainNumber();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setTrainNumber method sets the incorrect train number.
     */
    @Test
    void testSetTrainNumberWithInvalidInput() {
        String expected = "INVALID";
        train.setTrainNumber("-124B");
        String actual = train.getTrainNumber();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setDepartureLine method sets the correct departure line.
     */
    @Test
    void testSetDepartureLineWithValidInput() {
        String expected = "A2";
        train.setDepartureLine("A2");
        String actual = train.getDepartureLine();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setDepartureLine method sets the incorrect departure line.
     */
    @Test
    void testSetDepartureLineWithInvalidInput() {
        String expected = "INVALID";
        train.setDepartureLine("222A");
        String actual = train.getDepartureLine();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setDestination method sets the correct destination.
     */
    @Test
    void testSetDestinationWithValidInput() {
        String expected = "Trondheim";
        train.setDestination("Trondheim");
        String actual = train.getDestination();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setDepartureTime method sets the correct departure time.
     */
    @Test
    void testSetDepartureTimeWithValidInput() {
        String expected = "12:01";
        train.setDepartureTime("12:01");
        String actual = train.getDepartureTime();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setDepartureTime method sets the incorrect departure time.
     */
    @Test
    void testSetDepartureTimeWithInvalidInput() {
        String expected = "00:00";
        train.setDepartureTime("12:011");
        String actual = train.getDepartureTime();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setTrack method sets the correct track number.
     */
    @Test
    void testSetTrackWithValidInput() {
        int expected = 2;
        train.setTrack(2);
        int actual = train.getTrack();
        assertEquals(expected, actual);
    }
    /**
     * Test that the setTrack method sets the incorrect track number.
     */
    @Test
    void testSetTrackWithInvalidInput() {
        int expected = -1;
        train.setTrack(-2);
        int actual = train.getTrack();
        assertEquals(expected, actual);
    }

}
