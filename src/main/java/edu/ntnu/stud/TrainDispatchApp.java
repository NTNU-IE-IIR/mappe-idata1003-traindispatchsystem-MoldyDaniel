package edu.ntnu.stud;
import java.util.Scanner;
/**
 * This is the main class for the train dispatch application.
 */
public class TrainDispatchApp {
    /**
     * Start the application.
     * While strating the Clock and Departures classes while displaying the current time and the next departure.
     * Detect what the user writes into the console and convert it to an integer.
     * Then make the clock tick the amount of minutes the user wrote and display the new time.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Clock clock = new Clock();
        //Departures departures = new Departures();
            System.out.println("The time is " + clock.getHours() + ":" + clock.getMinutes());
            //System.out.println("The next departure is at " + departures.getNextDeparture(clock.getHours(), clock.getMinutes()));
            clock.tick(10);
            System.out.println("The time is " + clock.getHours() + ":" + clock.getMinutes());
        System.out.println("Enter the number of minutes to advance the clock: ");
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();
        clock.tick(minutes);
        System.out.println("The time is " + (clock.getHours()) + ":" + clock.getMinutes());
    }
    /**
     * Own class for system scanner.
     * Detect what the user writes into the console and convert it to an integer.
     * Then make the clock tick the amount of minutes the user wrote and display the new time.
     */

  // TODO: Fill in the main method and any other methods you need.
}
