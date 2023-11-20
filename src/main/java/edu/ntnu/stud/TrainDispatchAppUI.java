package edu.ntnu.stud;
import java.util.Scanner;
public class TrainDispatchAppUI {
    // The register of trains holding all the trains.
    private TrainRegister trainRegister;
    //The train class.
    private Train train;

    // A String constant holding the current version of the application.
    private static final String VERSION = "v-1.0-SNAPSHOT";

    /**
     * Menu choices
     */

    private static final int ADD_NEW_TRAIN = 1;
    private static final int PRINT_ALL_TRAINS = 2;
    private static final int PRINT_ALL_TRAINS_BY_DEPARTURE = 3;
    private static final int INCREMENT_CLOCK = 4;
    private static final int SET_CLOCK = 5;
    private static final int SET_TRACK_BY_TRAIN_NUMBER = 6;
    private static final int SET_DELAY_BY_TRAIN_NUMBER = 7;
    private static final int SET_DEPARTURE_TIME_BY_TRAIN_NUMBER = 8;
    private static final int DELETE_TRAIN_BY_TRAIN_NUMBER = 9;
    private static final int EXIT = 10;
    private static final int MAX_MENU_CHOICE = 10;

    public TrainDispatchAppUI() {
        //Intentionally empty
    }

    void init() {
        this.trainRegister = new TrainRegister();
        trainRegister.fillTrainRegister();
    }

    public void start() {

        /**
         * The main loop of the application.
         * This loop runs until the user wants to exit the application.
         * The user is presented with a menu, and the user's choice is executed.
         */
        boolean finished = false;
        while (!finished) {
            printWelcomeScreen();
            displayMenu();
            int selectedMenu = getUsersMenuChoice();
            if (!excetuteMenuChoice(selectedMenu)) {
                finished = true;
            }
        }
        // The application is finished. Print a goodbye message to the user.
        System.out.println("Thank you for using the Train Dispatch Application. Bye!");
    }

    /**
     * Prints a welcome screen to the console.
     */
    private void printWelcomeScreen() {
        System.out.println("\n Welcome to the Train Dispatch Application " + VERSION);
        System.out.println("========================================");
    }

    /**
     * Displays the menu to the user.
     */
    private void displayMenu() {
        System.out.println("Please select an action:");
        System.out.println("1. Add new train");
        System.out.println("2. Print all trains");
        System.out.println("3. Print next departure");
        System.out.println("4. Increment clock");
        System.out.println("5. Set clock");
        System.out.println("6. Set track by train number");
        System.out.println("7. Set delay by train number");
        System.out.println("8. Set departure time by train number");
        System.out.println("9. Delete train by train number");
        System.out.println("10. Exit");
    }

    /**
     * Excetutes the menu choice the user selected.
     *
     * <p>If the choice is a valid option, the command is executed,
     * and {@code true} is returned</p>
     *
     * <p>If the user decided to exit the application, {@code false} is returned</p>
     *
     * @param selectedMenu the menu choice.
     * @return false if user wants to exit the application, otherwise true.
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
            case PRINT_ALL_TRAINS_BY_DEPARTURE:
                //this.printAllTrainsByDeparture();
                break;
            case INCREMENT_CLOCK:
                //this.incrementClock();//TODO: Fix the clock.
                break;
            case SET_CLOCK:
                //this.setClock();//TODO: Fix the clock.
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
     * Asks the user for which menu the user wants to execute.
     * Verifies that the user input is a valid menu choice between 1 and {@code MAX_MENU_CHOICE}.
     * If not, -1 is returned to signal that a wrong input was given.
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

    /**
     * Adds a new train to the register.
     */
    private void addNewTrain(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the train number:");
        String trainNumber = userInput.nextLine();
        System.out.println("Please enter the departure line:");
        String departureLine = userInput.nextLine();
        System.out.println("Please enter the destination:");
        String destination = userInput.nextLine();
        System.out.println("Please enter the departure time:");
        String departureTime = userInput.nextLine();
        System.out.println("Please enter the track:");
        int track = userInput.nextInt();
        this.trainRegister.addTrains(new Train(trainNumber,departureLine,destination,departureTime,track));
    }
    private void printFormat(Train train){
        System.out.println("Train number:" + train.getTrainNumber() + "\n" +
                "Departure Line:" + train.getDepartureLine() + "\n" +
                "Destination:" + train.getDestination() + "\n" +
                "Departure time:" + train.getDepartureTime() + "\n" +
                "Track:" + train.getTrack() + "\n" +
                "=======================================");
    }
    private void printAllTrains(){
        /**for(this.trainRegister.displayTrainRegister()){
            System.out.println(each);
        }*/
        System.out.println("=======================================");
        for (Train train : this.trainRegister.getTrainRegister().values()) {
            printFormat(train);
        }

    }
    private void printAllTrainsByDeparture(){
        //System.out.println(this.trainRegister.displayTrainRegisterByDeparture());
    }

    /**
     * TODO:Set up guard cases for the methods.
     *
     */
    private void setTrackByTrainNumber(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the train number:");
        String trainNumber = userInput.nextLine();
        System.out.println("Please enter the track:");
        int track = userInput.nextInt();
        this.trainRegister.getTrainByTrainNumber(trainNumber).setTrack(track);

    }
    private void setDelayByTrainNumber(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the train number:");
        String trainNumber = userInput.nextLine();
        System.out.println("Please enter the delay in minutes:");
        String delay = userInput.nextLine();
        this.trainRegister.departure(trainNumber,delay);
    }
    private void setDepartureTimeByTrainNumber(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the train number:");
        String trainNumber = userInput.nextLine();
        System.out.println("Please enter the new departure time:");
        String departureTime = userInput.nextLine();
        this.trainRegister.getTrainByTrainNumber(trainNumber).setDepartureTime(departureTime);
    }
    private void deleteTrainByTrainNumber(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the train number:");
        String trainNumber = userInput.nextLine();
        this.trainRegister.removeTrain(trainNumber);
    }
}
