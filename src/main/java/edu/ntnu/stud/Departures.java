package edu.ntnu.stud;
import java.time.LocalTime;

/**
 * This is the main class for the train dispatch application. Which will store unique departure lines and train numbers.
 * The class will also store information about when the train departs and be able to update the time based on delays.
 * The class will also have functions to return information about the next departure, train number and departure lines.
 * These functions will be used in the TrainDispatchApp class
 * to display the amount of time till the next departure and when it leaves.
 */
public class Departures {

    /**
     * @param delay Decides how long the train will be delayed by. Must be withing the "tt:mm" format for the localtime class with
     * 24 hour showing. If there is no delay, the departureTime will be set to "00:00".
     */
    private String delay;
    private LocalTime departureTime;

    public Departures(String delay,String departureTime,Train train) {
        //System.out.println(departureTime);
        this.setDelay(delay,departureTime,train);
        //System.out.println(this.departureTime);

    }

    private void setDelay(String delay,String departureTime,Train train) {
        if (delay.length() != 5) {
            this.delay = "00:00";
        } else {
            String[] time = delay.split(":");

            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                this.delay = "00:00";
                this.departureTime = LocalTime.parse(this.delay);
            } else {
                //adds togheter the departure time and the delay to get the new departure time.
                this.departureTime = LocalTime.parse(departureTime).plusHours(hours).plusMinutes(minutes);
                train.setDepartureTime(this.departureTime.toString());
            }
        }
    }
    public Object getDelay(){
        return this.departureTime;
    }
    /**public String getNextDeparture(int hours, int minutes) {
        //return (this.departureTime.getHour() - hours) + ":" + (this.departureTime.getMinute() - minutes);
    }*/
}
