package edu.ntnu.stud;
import java.util.Scanner;
/**
 * This is the main class for the train dispatch application.
 */
public class TrainDispatchApp {
    //Starts the application.
    public static void main(String[] args) {
        TrainDispatchAppUI trainDispatchAppUI = new TrainDispatchAppUI();
        trainDispatchAppUI.init();
        trainDispatchAppUI.start();
    }













    ///**
    // * Start the application.
    // * While strating the Clock and Departures classes while displaying the current time and the next departure.
    // * Detect what the user writes into the console and convert it to an integer.
    // * Then make the clock tick the amount of minutes the user wrote and display the new time.
    // * @param args command-line arguments
    // */
    ///**Train train = new Train("123","A1","Oslo","12:00",1);
    //Departures departures = new Departures("12:34",train.getDepartureTime());*/
    //public static void main(String[] args) {
    //    Clock clock = new Clock();
    //    //Departures departures = new Departures();
    //        System.out.println("The time is " + clock.getHours() + ":" + clock.getMinutes());
//
    //        clock.tick(50);
    //        System.out.println("The time is " + clock.getHours() + ":" + clock.getMinutes());
    //    /**System.out.println("Enter the number of minutes to advance the clock: ");
    //    Scanner scanner = new Scanner(System.in);
    //    int minutes = scanner.nextInt();
    //    clock.tick(minutes);
    //    System.out.println("The time is " + (clock.getHours()) + ":" + clock.getMinutes());*/
    //    Train train = new Train("123","A1","Oslo","12:00",1);
    //    Departures departures = new Departures("02:34",train.getDepartureTime(),train);
    //    System.out.print(train.trainToString());
    //    //TODO: Fix the next departure function. because the minutes and hours can become negative.
    //    //System.out.println("\n"+"The next departure is in " + departures.getNextDeparture(clock.getHours(), clock.getMinutes()));
//
//
    //}
    ///**
    // * Own class for system scanner.
    // * Detect what the user writes into the console and convert it to an integer.
    // * Then make the clock tick the amount of minutes the user wrote and display the new time.
    // */
//
  //// TODO: Fill in the main method and any other methods you need.
}
