package edu.ntnu.stud.logic;

import edu.ntnu.stud.ui.TrainDispatchAppUI;

/** This is the main class for the train dispatch application. */
public class TrainDispatchApp {
  /**
   * Start the application.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    TrainDispatchAppUI trainDispatchAppUI = new TrainDispatchAppUI();
    trainDispatchAppUI.init();
    trainDispatchAppUI.start();
  }

  /// **
  // * Start the application.
  // * While strating the Clock and Departures classes while displaying the current time and the
  // next departure.
  // * Detect what the user writes into the console and convert it to an integer.
  // * Then make the clock tick the amount of minutes the user wrote and display the new time.
  // * @param args command-line arguments

  // }
  /// **
  // * Own class for system scanner.
  // * Detect what the user writes into the console and convert it to an integer.
  // * Then make the clock tick the amount of minutes the user wrote and display the new time.
  // */
  //
  //// TODO: Fill in the main method and any other methods you need.
}
