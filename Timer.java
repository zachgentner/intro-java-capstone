public class Timer {
    long startTime;
    long endTime;


    public Timer() {}

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public int timeInSeconds() {
        float sec = (endTime - startTime) / 1000F;
    
        return Math.round(sec);
    }
}