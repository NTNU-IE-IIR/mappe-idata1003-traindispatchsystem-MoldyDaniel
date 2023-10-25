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
        return time.getHour();
    }
     /**
     * @return the current minute of the hour
     */
    public int getMinutes() {
        return time.getMinute();
    }
     /**
     * Advance the time by the given number of minutes.
     */
    public void tick(int minutes) {
        time = time.plusMinutes(minutes);
    }
}
