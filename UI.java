import java.util.*;
import java.io.*;
import java.nio.*;

// UI handles rendering text to the console for the user to interact with.
public class UI {
    static boolean running = true;

    // Begins the program loop that runs until it's instructed to stop.
    public static void startProgram(Scanner input) {
        welcomeMessage();

        while(running) {
            System.out.print("> ");
            getInput(input.nextLine());
        }
  
    }

    // Greets the user when they initially run the program.
    private static void welcomeMessage() {
        System.out.println("Welcome to the reading speed assessment program!\n");
        System.out.println("Instructions for this program can be viewed by typing 'help'.");
        System.out.println("If you have not yet taken an assessment, please type 'test'.\n");
    }

    // Acknowledges the user when they elect to end the program.
    private static void goodbyeMessage() {
        System.out.println("\nThanks for using the reading speed assessment program!");
    }

    //Loads the file content to the console for viewing.
    public static void loadContent(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            System.out.println("");
            while(fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    // Analyzes user input and provides an appropriate response to select commands.
    private static void getInput(String userInput) {
        String input = userInput.toString().toLowerCase();

        // Terminates the main thread of the program.
        if (input.equals("stop") || input.equals("exit") || input.equals("quit")) {
            goodbyeMessage();
            running = false;
        }

        // Initiates the reading assessment.
        else if (input.equals("test") || input.equals("quiz") || input.equals("exam")) {
            try {
                File file = new File("samples/babbage.txt");
                Scanner scanner = new Scanner(System.in);
                Assessment.start(file, scanner);
            } catch (Exception e) {
                System.out.println("Error: Test file could not be found!");
            }
        }

        // Provides the user with their current reading speed.
        else if (input.equals("score") || input.equals("result") || input.equals("wpm")) {
            System.out.println("\nYour reading speed is " + Assessment.loadWPM() + " (WPM) words per minute.");
            System.out.println("Compared to everyone else, you are " + Utility.getSpeedLevel(Assessment.loadWPM()) + " reader.\n");
            System.out.println("It would take you roughly this long to read texts of various sizes.\n");
            Utility.timeBySpeed(Assessment.loadWPM());
            System.out.println("");
        }

        // Loads local text files into the console, providing estimated reading times.
        else if (input.equals("read") || input.equals("load") || input.equals("view")) {
            Scanner s = new Scanner(System.in);
            boolean running = true;
            while(running) {
                try {
                    System.out.println("\nType in the path of the file you would like to load.");
                    System.out.println("To return to the main menu, enter 'cancel', 'exit', or 'quit'.\n");
                    String fileName = s.nextLine().toString().toLowerCase();
                    System.out.println("");
                    File toLoad = new File(fileName);

                    if(fileName.equals("cancel") || fileName.equals("exit") || fileName.equals("quit")) {
                        break;
                    } else if(toLoad.exists() && toLoad.isFile() && toLoad.canRead()) {
                        Utility.timeToRead(Utility.wordsInFile(toLoad), Assessment.loadWPM());
                        while(true) {
                            System.out.println("Continue? Yes (Y) or No (N).\n");
                            System.out.print("> ");
                            String response = s.nextLine().toString().toLowerCase();
                            if(response.equals("no") || response.equals("n")) {
                                break;
                            } else if (response.equals("yes") || response.equals("y")) {
                                loadContent(toLoad);
                                System.out.println("");
                                running = false;
                                break;
                            } else {
                                System.out.println("");
                            }
                        }

                    } else {
                        throw new IOException();
                    }
                }
                catch (Exception e) {
                    System.out.println("Error: File not found or not compatible!");
                } 
            }
        }

        // Gives the user a list of commands to navigate the program.
        else if (input.equals("help") || input.equals("manual") || input.equals("man")) {
            System.out.println("");
            System.out.println("Exit: Enter 'quit', 'exit', or 'stop'.");
            System.out.println("Help: Enter 'help', 'manual', or 'man'.");
            System.out.println("Read: Enter 'read', 'load', or 'view'.");
            System.out.println("Test: Enter 'test', 'quiz', or 'exam'.");
            System.out.println("WPM: Enter 'score', 'result', or 'wpm'.");
            System.out.println("");
        }

        // Default response if the command is invalid.
        else { System.out.println("\nUnknown command. Enter 'help' for a list of commands.\n"); }
    }


}