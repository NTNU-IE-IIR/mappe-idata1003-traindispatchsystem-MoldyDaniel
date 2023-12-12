package edu.ntnu.stud.logic;

import edu.ntnu.stud.ui.TrainDispatchAppUI;

/**
 * The TrainDispatchApp class serves as the entry point for the train dispatch application.
 *
 * <p>This class initiates the train dispatch application by creating an instance of the {@link
 * TrainDispatchAppUI} class, initializing it, and starting the application through the UI.
 *
 * <p>Functionalities:
 *
 * <ul>
 *   <li>Acts as the entry point for the train dispatch application.
 *   <li>Initializes and starts the application by creating an instance of {@link
 *       TrainDispatchAppUI}.
 * </ul>
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class TrainDispatchApp {
  /**
   * Start the train dispatch application.
   *
   * @param args Command-line arguments (not used in this application)
   */
  public static void main(String[] args) {
    // Creating an instance of TrainDispatchAppUI
    TrainDispatchAppUI trainDispatchAppUI = new TrainDispatchAppUI();

    // Initializing and starting the TrainDispatchAppUI
    trainDispatchAppUI.init();
    trainDispatchAppUI.start();
  }
}
