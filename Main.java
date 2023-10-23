import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class Main {

  public static int numberOfWords(File file) {
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

  // Saves the users WPM to a local file for future recovery.
  public static void saveWPM(int wordsPerMinute) {
    try {
        File output = new File("speed.txt");
        Files.writeString(output.toPath(), String.valueOf(wordsPerMinute), StandardOpenOption.CREATE, 
                         StandardOpenOption.TRUNCATE_EXISTING);
      }
      catch(IOException e) {
        System.out.println("Error: " + e.getMessage());
      } 
  }

  // Loads the user's WPM into the program for continuity.
  public static int loadWPM() {
    try {
        File speed = new File("speed.txt");
        Scanner fileScanner = new Scanner(speed);
        if(fileScanner.hasNextLine()) {
            int result = Integer.parseInt(fileScanner.nextLine());
            if (result >= 0) { return result; }
            // return Integer.parseInt(fileScanner.nextLine());
        }
    } catch (Exception e) {
        System.out.println("Previous test scores could not be loaded.");
    }
        return -1;
  }

  // Manually sets the WPM in order to bypass the assessment.
  public static void manualWPM(int wordsPerMinute) {
    saveWPM(wordsPerMinute);
  }

  public static int minutesToRead(int words, int speed) {
    return words / speed;
  }

  public static void timeToRead(int words, int speed) {
    int minutes = words / speed;

    if (minutes < 1) {
      System.out.println("Time to read: less than a minute.");
    } else if (minutes >= 1 && minutes < 2) {
      System.out.println("Time to read: " + minutes + " minute.");
    } else {
      System.out.println("Time to read: " + minutes + " minutes.");
    }
  }

  public static void timeByWords(int words) {
    System.out.println("150WPM (Slow): " + minutesToRead(words, 150) + " minutes");
    System.out.println("250WPM (Avg):  " + minutesToRead(words, 250) + " minutes");
    System.out.println("400WPM (Fast): " + minutesToRead(words, 400) + " minutes");
    System.out.println("600WPM (Pro):  " + minutesToRead(words, 600) + " minutes");
  }

  public static void timeBySpeed(int speed) {
    System.out.println("500 Words:   " + minutesToRead(500, speed) + " minutes");
    System.out.println("1000 Words:  " + minutesToRead(1000, speed) + " minutes");
    System.out.println("2500 Words:  " + minutesToRead(2500, speed) + " minutes");
    System.out.println("5000 Words:  " + minutesToRead(5000, speed) + " minutes");
    System.out.println("7500 Words:  " + minutesToRead(7500, speed) + " minutes");
    System.out.println("10000 Words: " + minutesToRead(10000, speed) + " minutes");
  }

  public static void startProgram(Scanner input) {
      System.out.println("Welcome. Please enter a reading speed.");

  }
  
  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);
    int speed = 0;
    File file = new File("samples/10000words.txt");
    

    // while(!(speed > 0) || !(speed <= 600)) {
    //   try {
    //     int temp = input.nextInt();
    //     if (temp > 0 && temp < 600) {
    //       speed = temp;
    //     } else {
    //       System.out.println("Please enter a valid number.");
    //     }
    //   } catch(Exception e) {
    //     System.out.println("Please enter a valid number.");
    //     input.nextLine();
    //   }
    // }

    saveWPM(400);
    manualWPM(100);
    System.out.println(loadWPM());


  }
}