import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

//Assessment provides all of the necessary methods for administering a reading test to the user.
public class Assessment {

  //Begins the loop to administer the reading assessment.
  public static void start(File file, Scanner input) {
    boolean running = false;
    Timer timer = new Timer();

    System.out.println("\nThis assessment will test and record your reading speed for future use.");
    System.out.println("Note: Performing this test will overwrtie any saved data you currently have!\n");
    System.out.println("Enter 'start' to begin the assessment or 'cancel' to return to the menu.\n");
    while(true) {
        try {
            String response = input.next();
            if (response.toLowerCase().equals("cancel")) {
                System.out.println("\nAssessment successfully cancelled.\n");
                running = false;
                break;
            }
            else if (response.toLowerCase().equals("start")) {
                timer.start();
                File testFile = new File("samples/babbage.txt");
                UI.loadContent(testFile);
                running = true;
                break;
            }
            else {
                System.out.println("\nUnknown command. Please enter 'start' to begin or 'cancel' to exit.\n");
            }
        } catch (Exception e) {
            System.out.println("An error has occurred.");
        }
    }

    while(running) {
        System.out.println("\nEnter 'end' to complete the assessment.\n");
        try {
            String response = input.next();
            if(response.equals("end")) {
                timer.stop();
                int wpm = Utility.getWordsPerMinute(Utility.wordsInFile(file), timer.timeInSeconds());
                saveWPM(wpm);
                System.out.println("\nYour reading speed is " + wpm + " (WPM) words per minute.");
                System.out.println("You are " + Utility.getSpeedLevel(Assessment.loadWPM()) + " reader.\n");
                running = false;
            }
        } catch (Exception e) {
            System.out.println("Unexpected error!");
        }
    }

  }

  // Saves the users WPM to a local file for future recovery.
  public static void saveWPM(int wordsPerMinute) {
    try {
        File output = new File("wpm.txt");
        Files.writeString(output.toPath(), String.valueOf(wordsPerMinute), StandardOpenOption.CREATE, 
                         StandardOpenOption.TRUNCATE_EXISTING);
      }
      catch(IOException e) {
        System.out.println("Error: " + e.getMessage());
      } 
  }

  // Loads the user's WPM from a local file for continuity.
  public static int loadWPM() {
    try {
        File speed = new File("wpm.txt");
        Scanner fileScanner = new Scanner(speed);
        if(fileScanner.hasNextLine()) {
            int result = Integer.parseInt(fileScanner.nextLine());
            if (result >= 0) { return result; }
            // return Integer.parseInt(fileScanner.nextLine());
        }
    } catch (Exception e) {
        System.out.println("Previous test scores could not be loaded.");
    }
        return 0;
  }

}