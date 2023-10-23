import java.util.*;
import java.io.*;
import java.nio.*;

public class Utility {

    // Returns WPM based on the words within a text and the seconds taken to read them.
    public static int getWordsPerMinute(int words, int seconds) {
        return (int) Math.round((double) words / seconds * 60);
    }

    // Returns total whole minutes to read based on the words within a text and the WPM speed.
    public static int minutesToRead(int words, int wpm) {
        if (wpm > 0 && words > 0) {
         return words / wpm;
        } else {
            return 0;
        }
    }
    
    // Returns a plain English representation of the total time a specific text would take to read.
    public static void timeToRead(int words, int speed) {
        if (speed > 0) {
            int minutes = words / speed;
    
            if (minutes < 1) {
                System.out.println("Time to read: less than a minute.");
            } else if (minutes >= 1 && minutes < 2) {
                System.out.println("Time to read: " + minutes + " minute.");
            } else {
                System.out.println("Time to read: " + minutes + " minutes.");
            }
        }
    }

    // Returns the estimated time to read a text of n words for those at different reading levels.
    public static void timeByWords(int words) {
        System.out.println("150WPM (Slow): " + minutesToRead(words, 150) + " minutes");
        System.out.println("250WPM (Avg):  " + minutesToRead(words, 250) + " minutes");
        System.out.println("400WPM (Fast): " + minutesToRead(words, 400) + " minutes");
        System.out.println("600WPM (Pro):  " + minutesToRead(words, 600) + " minutes");
    }

    // Returns the estimated time to read based on a speed in wpm.
    public static void timeBySpeed(int speed) {
        System.out.println("500 Words:   " + minutesToRead(500, speed) + " minutes");
        System.out.println("1000 Words:  " + minutesToRead(1000, speed) + " minutes");
        System.out.println("2500 Words:  " + minutesToRead(2500, speed) + " minutes");
        System.out.println("5000 Words:  " + minutesToRead(5000, speed) + " minutes");
        System.out.println("7500 Words:  " + minutesToRead(7500, speed) + " minutes");
        System.out.println("10000 Words: " + minutesToRead(10000, speed) + " minutes");
    }

    // Returns a whole number representing the number of words contained in a file.
    public static int wordsInFile(File file) {
        int count = 0;
        try {
          Scanner scanner = new Scanner(file);
          while (scanner.hasNext()) {
            String word = scanner.next();
            count++;
          }
        } catch (FileNotFoundException e) {
          System.out.println("File not found: " + file.getName());
        }
        return count;
    }

    // Returns a string value for the 'level' of reading speed.
    public static String getSpeedLevel(int wpm) {
        if (wpm >= 600) {
            return "a professional";
        } else if (wpm >= 400) {
            return "a fast";
        } else if (wpm >= 250) {
            return "an average";
        } else {
            return "a slow";
        }
    }
}