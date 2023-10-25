package edu.ntnu.stud;

/**
 * This is the main class for the train dispatch application.
 */
public class TrainDispatchApp {
    /**
     * Start the application.
     * While strating the Clock and Departures classes while displaying the current time and the next departure.
     * @param args
     */
    public static void main(String[] args) {
        Clock clock = new Clock();
        Departures departures = new Departures();
            System.out.println("The time is " + clock.getHours() + ":" + clock.getMinutes());
            //System.out.println("The next departure is at " + departures.getNextDeparture(clock.getHours(), clock.getMinutes()));
            clock.tick(10);
            System.out.println("The time is " + clock.getHours() + ":" + clock.getMinutes());

    }
  // TODO: Fill in the main method and any other methods you need.
}
