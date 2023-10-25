package edu.ntnu.stud;

import java.util.HashMap;

/**
 * This is the main class for the train dispatch application. Which will store unique departure lines and train numbers.
 * The class will also store information about when the train departs and be able to update the time based on delays.
 * The class will also have functions to return information about the next departure, train number and departure lines.
 * These functions will be used in the TrainDispatchApp class
 * to display the amount of time till the next departure and when it leaves.
 */
public class Departures {

    /**
     * Create Train object with the given train number and departure line.
     * (Might use HashMap to store unique departure lines and train numbers)
     */
    public class Train {
        private int trainNumber;
        private String departureLine;

        /**
         * Create a new Train object with the given train number and departure line.
         */
        public Train(int trainNumber, String departureLine) {
            this.trainNumber = trainNumber;
            this.departureLine = departureLine;
        }

        /**
         * @return the train number
         */
        public int getTrainNumber() {
            return trainNumber;
        }

        /**
         * @return the departure line
         */
        public String getDepartureLine() {
            return departureLine;
        }
    }
}
