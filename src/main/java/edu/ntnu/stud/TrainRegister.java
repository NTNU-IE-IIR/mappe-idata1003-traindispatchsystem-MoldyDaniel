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
     * Adds the trainClock to the trainRegister.
     * @param increase the amount of time to increase the clock by.
     *
     */
    public void incrementTrainClock(String increase){
        this.TrainClock.increment(increase,this.TrainClock.getTime());
    }
    public String getTrainClock(){
        return TrainClock.getTime();
    }
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
    public boolean removeTrains(Train train){
        return false;
    }


    public void fillTrainRegister(){
        this.addTrains(new Train("123","A1","Oslo","12:00",1));
        this.addTrains(new Train("124","A1","Oslo","12:00",1));
        this.addTrains(new Train("125","A1","Oslo","12:00",1));
        this.addTrains(new Train("126","A1","Oslo","12:00",1));
        this.addTrains(new Train("123","A1","Oslo","12:00",1));
    }
    public String displayTrainRegister(){
        String trainRegister = "";
        for(Train train : this.trains.values()){
            trainRegister += train.trainToString() + "\n" + "-----------------------------------" + "\n";
        }
        return trainRegister;
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
    public void getTrainByDestination(String destination){
        for(Train train : this.trains.values()){
            if(train.getDestination().equals(destination)){
                System.out.println(train.trainToString());
            }
        }
    }
    public void getTrainByTrainNumber(String trainNumber){
        for(Train train : this.trains.values()){
            if(train.getTrainNumber().equals(trainNumber)){
                System.out.println(train.trainToString());
            }
        }
    }
}

