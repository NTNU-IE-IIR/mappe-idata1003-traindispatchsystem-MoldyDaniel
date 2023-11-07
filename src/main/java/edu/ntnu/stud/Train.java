package edu.ntnu.stud;

public class Train {
    private int trainNumber;
    private String departureLine;

    /**
     * Create a new Train object with the given train number and departure line.
     */
    /**
     * Create Train object with the given train number and departure line.
     * (Might use HashMap to store unique departure lines and train numbers)
     */
    public Train(int trainNumber, String departureLine) {
        this.trainNumber = trainNumber;
        this.departureLine = departureLine;
    }


    /**
     * @return the train number
     * Trainregister
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
