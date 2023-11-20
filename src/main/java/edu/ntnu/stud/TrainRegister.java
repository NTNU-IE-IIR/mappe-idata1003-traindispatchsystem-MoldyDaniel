package edu.ntnu.stud;

import java.util.HashMap;

public class TrainRegister {
    private HashMap<String,Train> trains;
    private Clock TrainClock;
    private Train train;
    private Departures departures;
    public TrainRegister(){
        this.trains = new HashMap<>();
        this.TrainClock = new Clock();
    }
    /**
     * Make removing trains after departure time has passed work as a function instead of automatically.
     */
    /**
     * Adds the trainClock to the trainRegister.
     * @param increase the amount of time to increase the clock by.
     *TODO: Put in clock class.
     */
    public void incrementTrainClock(String increase) {
        this.TrainClock.increment(increase, this.TrainClock.getTime());
        /**String[] trainClock = this.TrainClock.getTime().split(":");
        int hours1 = Integer.parseInt(trainClock[0]);
        int minutes1 = Integer.parseInt(trainClock[1]);
        for (Train train : this.trains.values()) {
            String[] trainDeparture = train.getDepartureTime().split(":");
            int hours2 = Integer.parseInt(trainDeparture[0]);
            int minutes2 = Integer.parseInt(trainDeparture[1]);
            if (hours1 > hours2 || (hours1 == hours2 && minutes1 > minutes2)) {
                this.trains.remove(train.getTrainNumber());
            }
        }*/
    }
    public String getTrainClock(){
        return TrainClock.getTime();
    }

    /**
     * Adds the train to the trainRegister if the train number is unique
     * and the departure line, destination and departure time is valid.
     * @param train
     * @return true if the train is added to the trainRegister.
     */
    public boolean addTrains(Train train){
        if(this.trains.containsKey(train.getTrainNumber()) || train.getTrainNumber().equals("INVALID")){
            return false;
        }
        if(train.getDepartureLine().equals("INVALID") || train.getDestination().equals("INVALID") || train.getDepartureTime().equals("INVALID")){
            return false;
        }
        else{
            this.trains.put(train.getTrainNumber(),train);
            return true;
        }
    }
    public boolean removeTrain(String trainNumber){
        if(this.trains.containsKey(trainNumber)){
            this.trains.remove(trainNumber);
            return true;
        }
        return false;
    }
    /**
     * Removes the train from the trainRegister if the train is behind the current time.
     * @param train
     * @return
     * TODO:Should not think about the time and only delete.
     */
    public boolean removeTrains(Train train){
        if(this.trains.containsKey(train.getTrainNumber())){
            if(this.TrainClock.getTime().compareTo(train.getDepartureTime()) > 0){
                this.trains.remove(train.getTrainNumber());
                return true;
            }
        }
        return false;
    }


    public void fillTrainRegister(){
        this.addTrains(new Train("123","A1","Oslo","12:00",1));
        this.addTrains(new Train("124","A1","Oslo","12:00",1));
        this.addTrains(new Train("125","A1","Oslo","12:00",1));
        this.addTrains(new Train("126","A1","Oslo","12:00",1));
        this.addTrains(new Train("123","A1","Oslo","12:00",1));
    }

    /**
     * TODO: Handle the output in the UI class. Only return the values.
     * Return the trainRegister as a get function.
     * @return the trainRegister.
     */
    public HashMap<String,Train> getTrainRegister(){
        return trains;
    }

    /**
     * Delays the train by the given amount of minutes using the Departures class.
     * And the setDelay method in the Departures class.
     *
     * @param trainNumber the train number.
     */
    public void departure(String trainNumber, String delay){
        for(Train train : this.trains.values()){
            if(train.getTrainNumber().equals(trainNumber)){
                this.departures = new Departures(delay,train.getDepartureTime(),train);
                //System.out.println(train.trainToString());
            }
        }

    }

    /**
     * TODO: Return value instead of printing.
     * @param destination
     */
    public Train getTrainByDestination(String destination){
        for(Train train : this.trains.values()){
            if(train.getDestination().equals(destination)){
                return train;
            }
        }
        return null;
    }

    /**
     * TODO: Return value instead of printing.
     *
     * @param trainNumber
     * @return
     */
    public Train getTrainByTrainNumber(String trainNumber){
        for(Train train : this.trains.values()){
            if(train.getTrainNumber().equals(trainNumber)){
                return train;
            }
        }
        return null;
    }
}

