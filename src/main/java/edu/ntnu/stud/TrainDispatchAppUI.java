package edu.ntnu.stud;

public class TrainDispatchAppUI {
    private static final String VERSION = "v-1.0-SNAPSHOT";
    private TrainRegister trainRegister;

    void init(){
        this.trainRegister = new TrainRegister();
        trainRegister.fillTrainRegister();
    }
    public void start() {
        TrainDispatchAppUI trainDispatchAppUI = new TrainDispatchAppUI();
        trainDispatchAppUI.init();
        System.out.println("Welcome to the Train Dispatch App " + VERSION);
        System.out.println("Please enter a command. Type 'help' for a list of commands.");
        System.out.println(trainRegister.getTrainClock());
        System.out.println("-----------------------------------");
        System.out.println(trainRegister.displayTrainRegister());
        trainRegister.departure("126","08:38");
        System.out.println(trainRegister.displayTrainRegister());
        trainRegister.incrementTrainClock("12:01");
        System.out.println(trainRegister.getTrainClock());
    }
}
