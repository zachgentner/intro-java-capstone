import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class Main { 
  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);
    int wpm = Assessment.loadWPM();

    UI.startProgram(input);

    //Loop until user closes application.
    //Greet the user. Provide them with choices.
        //Take assessment.
        //Estimate reading time.
            //Option 1: Use standard reading speeds to get estimates.
            //Option 2: If WPM can be loaded, provide prompt to use that metric.

  }
}