/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class Cruncher {
    
    private Scanner inFileScanner;
    String inputFileLocation;
    String outputFileLocation;
    
    public Cruncher(String inputFile, String outputFile)
    {
        inputFileLocation = inputFile;
        outputFileLocation = outputFile;
    }
    
    public void openFiles()
    {
        try{
            // Scanner is said to be a wrapper class for the File class.
            inFileScanner = new Scanner(new File(inputFileLocation));
            while(inFileScanner.hasNextLine())
            {
                String line = inFileScanner.nextLine();
                System.out.printf("Line Contents: %s \n", line);
            }
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.printf("Error opening the file for reading: %s, ", inputFileLocation);
            System.exit(1);
        }
        
    }
    
    public void closeFiles()
    {
        if(inFileScanner != null){
            inFileScanner.close();
        }
    }
    
    public void findDistance()
    {
    }
    
    public void writeRecords()
    {
    }
}
