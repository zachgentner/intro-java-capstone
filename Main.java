import java.util.*;
import java.io.*;
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
  
  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);
    int speed = 0;
    File file = new File("./samples/babbage.txt");
    
    System.out.println("Welcome. Please enter a reading speed.");

    while(!(speed > 0) || !(speed <= 600)) {
      try {
        int temp = input.nextInt();
        if (temp > 0 && temp < 600) {
          speed = temp;
        } else {
          System.out.println("Please enter a valid number.");
        }
      } catch(Exception e) {
        System.out.println("Please enter a valid number.");
        input.nextLine();
      }
    }

    System.out.println("Number of words: " + numberOfWords(file));
    System.out.println("Reading speed: " + speed);
    System.out.println("Equation: " + (numberOfWords(file) / speed));
    timeToRead(numberOfWords(file), speed);
    
    
  }
}