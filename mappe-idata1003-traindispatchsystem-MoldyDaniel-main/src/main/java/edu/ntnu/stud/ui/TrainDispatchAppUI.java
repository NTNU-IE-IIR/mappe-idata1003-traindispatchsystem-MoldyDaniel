package edu.ntnu.stud.ui;

import edu.ntnu.stud.entity.Clock;
import edu.ntnu.stud.entity.Train;
import edu.ntnu.stud.logic.TrainRegister;
import java.util.Scanner;

/**
 * Represents the User Interface of the Train Dispatch Application. The User Interface (UI) is a
 * text-based menu-controlled system.
 *
 * <p>Through the menu, the user can perform the following actions:
 *
 * <ul>
 *   <li>Add a new train to the register
 *   <li>List all trains
 *   <li>Print details of trains by departure time
 *   <li>Set clock time
 *   <li>Set track number by train number
 *   <li>Set delay by train number
 *   <li>Set departure time by train number
 *   <li>Delete a train by train number
 *   <li>Print all trains by destination
 *   <li>Exit the application
 * </ul>
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class TrainDispatchAppUI {
  // A String constant holding the current version of the application.
  private static final String VERSION = "v-1.0-SNAPSHOT";

  /** Menu choices. */
  private static final int ADD_NEW_TRAIN = 1;

  private static final int PRINT_ALL_TRAINS = 2;
  private static final int PRINT_ALL_TRAINS_BY_DEPARTURE_TIME = 3;
  private static final int SET_CLOCK = 4;
  private static final int SET_TRACK_BY_TRAIN_NUMBER = 5;
  private static final int SET_DELAY_BY_TRAIN_NUMBER = 6;
  private static final int SET_DEPARTURE_TIME_BY_TRAIN_NUMBER = 7;
  private static final int DELETE_TRAIN_BY_TRAIN_NUMBER = 8;
  private static final int PRINT_ALL_TRAINS_BY_DESTINATION = 9;
  private static final int EXIT = 10;
  private static final int MAX_MENU_CHOICE = 10;

  // The register of trains holding all the trains.
  private TrainRegister trainRegister;
  // The train class.
  private Train train;
  // The clock class.
  private edu.ntnu.stud.entity.Clock clock;

  public TrainDispatchAppUI() {
    // Intentionally empty
  }

  /** Initializes the application. */
  public void init() {
    this.trainRegister = new TrainRegister();
    this.clock = new Clock();
  }

  /** Main loop of the application where the user interacts through a menu system. */
  public void start() {
    boolean finished = false;
    while (!finished) {
      printWelcomeScreen();
      displayMenu();
      trainRegister.deleteTrainAfterTime(this.trainRegister.getTrainRegister(), this.clock);
      int selectedMenu = getUsersMenuChoice();
      if (!excetuteMenuChoice(selectedMenu)) {
        finished = true;
      }
    }
    // The application is finished. Print a goodbye message to the user.
    System.out.println("Thank you for using the Train Dispatch Application. Bye!");
  }

  /** Prints a welcome message at the start of the application. */
  private void printWelcomeScreen() {
    System.out.println("\n Welcome to the Train Dispatch Application " + VERSION);
    System.out.println("========================================");
  }

  /** Displays the menu options to the user. */
  private void displayMenu() {
    System.out.println("Please select an action:");
    System.out.println("1. Add new train");
    System.out.println("2. Print all trains");
    System.out.println("3. Print departures sorted by departure time");
    System.out.println("4. Set clock");
    System.out.println("5. Set track by train number");
    System.out.println("6. Set delay by train number");
    System.out.println("7. Set departure time by train number");
    System.out.println("8. Delete train by train number");
    System.out.println("9. Print all trains by destination");
    System.out.println("10. Exit");
  }

  /**
   * Executes the selected menu choice by the user.
   *
   * <p>If the choice is a valid option, the command is executed, and {@code true} is returned
   *
   * <p>If the user decided to exit the application, {@code false} is returned
   *
   * @param selectedMenu The selected menu choice.
   * @return {@code false} if the user wants to exit the application, otherwise {@code true}.
   */
  private boolean excetuteMenuChoice(int selectedMenu) {
    boolean result = true;

    switch (selectedMenu) {
      case ADD_NEW_TRAIN:
        this.addNewTrain();
        break;
      case PRINT_ALL_TRAINS:
        this.printAllTrains();
        break;
      case PRINT_ALL_TRAINS_BY_DEPARTURE_TIME:
        this.printAllTrainsByDeparture();
        break;
      case SET_CLOCK:
        this.setClock();
        break;
      case SET_TRACK_BY_TRAIN_NUMBER:
        this.setTrackByTrainNumber();
        break;
      case SET_DELAY_BY_TRAIN_NUMBER:
        this.setDelayByTrainNumber();
        break;
      case SET_DEPARTURE_TIME_BY_TRAIN_NUMBER:
        this.setDepartureTimeByTrainNumber();
        break;
      case DELETE_TRAIN_BY_TRAIN_NUMBER:
        this.deleteTrainByTrainNumber();
        break;
      case PRINT_ALL_TRAINS_BY_DESTINATION:
        this.printAllTrainsByDestination();
        break;
      case EXIT:
        result = false;
        break;
      default:
        System.out.println("\nPlease enter a number between 1 and " + MAX_MENU_CHOICE);
        System.out.println("(You entered " + selectedMenu + ")");
        break;
    }
    return result;
  }

  /**
   * Asks the user for which menu the user wants to execute. Verifies that the user input is a valid
   * menu choice between 1 and {@code MAX_MENU_CHOICE}. If not, -1 is returned to signal that a
   * wrong input was given.
   *
   * @return the menu choice given by the user, or -1 if the user entered a wrong input.
   */
  private int getUsersMenuChoice() {
    int selectedMenu;

    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter a menu choice between 1 and " + MAX_MENU_CHOICE + ":");

    if (userInput.hasNextInt()) {
      selectedMenu = userInput.nextInt();
    } else {
      selectedMenu = -1;
    }
    return selectedMenu;
  }

  /** Adds a new train to the trainRegister. */
  private void addNewTrain() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the train number:");
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    String trainNumber = userInput.nextLine();
    System.out.println("Please enter the departure line:");
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    String departureLine = userInput.nextLine();
    System.out.println("Please enter the destination:");
    String destination = userInput.nextLine();
    System.out.println("Please enter the departure time:");
    String departureTime = userInput.nextLine();
    System.out.println("Please enter the track:");
    int track = userInput.nextInt();
    this.trainRegister.addTrains(
        new Train(trainNumber, departureLine, destination, departureTime, track));
  }

  /**
   * Prints the train in a specific format.
   *
   * @param train The train to be printed.
   */
  private void printFormat(Train train) {
    System.out.println(
        "Train number:"
            + train.getTrainNumber()
            + "\n"
            + "Departure Line:"
            + train.getDepartureLine()
            + "\n"
            + "Destination:"
            + train.getDestination()
            + "\n"
            + "Departure time:"
            + train.getDepartureTime()
            + "\n"
            + "Delayed to:"
            + clock.getDelayPlusDepartureTime(train.getDepartureTime(), train.getDelay())
            + "\n"
            + "Track:"
            + train.getTrack()
            + "\n"
            + "=======================================");
  }

  /** Prints all the trains in the trainRegister. */
  private void printAllTrains() {
    System.out.println("The Clock is " + this.clock.getTime());
    System.out.println("=======================================");
    for (Train train : this.trainRegister.getTrainRegister().values()) {
      printFormat(train);
    }
  }

  /** Prints all the trains in the trainRegister sorted by departure time. */
  private void printAllTrainsByDeparture() {
    // Print out the new sorted list of trains.
    for (Train train : this.trainRegister.sortTrainsByDepartureTime()) {
      printFormat(train);
    }
  }

  /** Prints all the trains in the trainRegister with the specified destination. */
  private void printAllTrainsByDestination() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the destination:");
    String input = userInput.nextLine();
    for (Train train : this.trainRegister.getTrainsByDestination(input)) {
      printFormat(train);
    }
  }

  /** Sets the clock time based on user input. */
  private void setClock() {
    Scanner userInput = new Scanner(System.in);
    System.out.println(
        "Please enter the what you want the clock to "
            + "be after the already set time in the 'hh:mm' format:");
    String input = userInput.nextLine();
    this.clock.setTime(input);
  }

  /** Sets the track number for a specific train based on user input. */
  private void setTrackByTrainNumber() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the train number:");
    String trainNumber = userInput.nextLine();
    System.out.println("Please enter the track:");
    int track = userInput.nextInt();
    this.trainRegister.getTrainByTrainNumber(trainNumber).setTrack(track);
  }

  /** Sets the delay for a specific train based on user input. */
  private void setDelayByTrainNumber() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the train number:");
    String trainNumber = userInput.nextLine();
    System.out.println("Please enter the delay in the 'hh:mm' format:");
    String delay = userInput.nextLine();
    train = this.trainRegister.getTrainByTrainNumber(trainNumber);
    train.setDelay(delay);
  }

  /** Sets the departure time for a specific train based on user input. */
  private void setDepartureTimeByTrainNumber() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the train number:");
    String trainNumber = userInput.nextLine();
    System.out.println("Please enter the new departure time in the 'hh:mm' format:");
    String departureTime = userInput.nextLine();
    this.trainRegister.getTrainByTrainNumber(trainNumber).setDepartureTime(departureTime);
  }

  /** Deletes a train from the register based on the provided train number by the user. */
  private void deleteTrainByTrainNumber() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the train number:");
    String trainNumber = userInput.nextLine();
    this.trainRegister.removeTrain(trainNumber);
  }
}
