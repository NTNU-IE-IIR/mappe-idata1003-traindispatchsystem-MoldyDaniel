package edu.ntnu.stud;
import java.time.LocalTime;
/**
 * Use LocalTime to represent the current time in hours and minutes.
 */
public class Clock {
    private LocalTime time;
    /**
     * Create a new Clock object with the time set to 00:00.
     */
    public Clock() {
        time = LocalTime.MIN;
    }
    /**
     * @return the current hour of the day
     */
    public int getHours() {
        return this.time.getHour();
    }
     /**
     * @return the current minute of the hour
     */
    public int getMinutes() {
        return this.time.getMinute();
    }
    /**
     * @return the current time as a string on the format "hh:mm"
     */
    public String getTime() {
        return this.time.toString();
}
     /**
     * Advance the time by the given number of minutes.
     */
    public void increment(String timeIncrease,String timeHold) {
        if (timeIncrease.length() != 5) {
            //this.time = LocalTime.parse(time).plusMinutes(1);
            this.time = LocalTime.parse(timeIncrease);
        } else {
            String[] split = timeIncrease.split(":");

            int hours = Integer.parseInt(split[0]);
            int minutes = Integer.parseInt(split[1]);
            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                this.time = LocalTime.parse(timeIncrease).plusMinutes(1);
            } else {
                //adds togheter the departure time and the delay to get the new departure time.
                this.time = LocalTime.parse(timeHold).plusHours(hours).plusMinutes(minutes);
            }
        }
    }
}

