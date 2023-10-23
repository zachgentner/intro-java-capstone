//Creates a simple timer that can measure time in seconds.
public class Timer {
    long startTime;
    long endTime;

    //Default constructor. No params needed.
    public Timer() {}

    //Starts the timer, passing the current time into an object attribute.
    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    
    //Stops the timer, passing the current time into an object attribute.
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    //Returns the total time, in seconds, from the start time to the end time.
    public int timeInSeconds() {
        float sec = (endTime - startTime) / 1000F;
    
        return Math.round(sec);
    }
}