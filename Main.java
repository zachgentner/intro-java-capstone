import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

// Main program class. This is where the magic happens!
public class Main { 
    // Main method for executing code.
  public static void main (String[] args) {

    Scanner input = new Scanner(System.in); //Declares a scanner to be used in the UI class.
    int wpm = Assessment.loadWPM(); //Loads the current UI into the program if it exists.
    UI.startProgram(input); //Prompts the UI to begin the program

    //Create a universal scanner to be used to gather user input.
    //Load the result of the last reading assessment into the program.
    //Start the UI and prompt the user until they manually close the application.
    //Greet the user. Introduce them to the basics of program functionality by pointing them to the help command.
    //COMMANDS
        //READ: Read a local file in the console.
            //User enters a local file path.
            //User receives an estimated reading time based on their current WPM.
            //User can choose to read the file or decline and exit to the main menu.
        //TEST: Take a reading assessment.
            //User receives a brief introduction to the test and a warning that previous scores are overwritten.
            //User can either start the assessment or cancel and return to the main menu.
            //If started, the user reads the test file and enters "end" to complete the assessment.
            //Once completed, the user receives their WPM and the new number is saved to wpm.txt.
        //WPM: Review the current WPM and relevant reading statistics.
        //EXIT: Terminate the program.
        //HELP: User can elect to review the above commands for ease of use.
    //Say goodbye to the user and thank them for using our program!

  }
}