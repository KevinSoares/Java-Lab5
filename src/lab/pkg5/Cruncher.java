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
    private Scanner inputScanner;
    private String inputFileLocation;
    private String outputFileLocation;
    private String city1;
    private String city2;
    private String[] city1Source;
    private String[] city2Source;
    private String[] city1RawLat;
    private String[] city1RawLong;
    private String[] city2RawLat;
    private String[] city2RawLong;
    
    private int city1LatMin;
    private int city1LatDegrees;
    private int city1LongMin;
    private int city1LongDegrees;
    private int city2LatMin;
    private int city2LatDegrees;
    private int city2LongMin;
    private int city2LongDegrees;
    
    public Cruncher(String inputFile, String outputFile)
    {
        inputFileLocation = inputFile;
        outputFileLocation = outputFile;
    }
    
    public void openFiles()
    {
        inputScanner = new Scanner(System.in);
        System.out.print("Enter first location as Prov:City ");
        city1 = inputScanner.nextLine();
        System.out.print("Enter second location as Prov:City ");
        city2 = inputScanner.nextLine();
        
        try{
            // Scanner is said to be a wrapper class for the File class.
            inFileScanner = new Scanner(new File(inputFileLocation));
            while(inFileScanner.hasNextLine())
            {
                String sourceLine = inFileScanner.nextLine();
                if(sourceLine.matches(city1 + ".*"))
                {
                    city1Source = sourceLine.split(":");
                    for(String inspect: city1Source){
                        System.out.printf("%s\n", inspect);
                    }
                    city1RawLat = city1Source[2].split("\\D+");
                    city1RawLong = city1Source[3].split("\\D+");
                    
                    city1LatDegrees = Integer.parseInt(city1RawLat[0]);
                    city1LatMin = Integer.parseInt(city1RawLat[1]);
                    city1LongDegrees = Integer.parseInt(city1RawLong[0]);
                    city1LongMin = Integer.parseInt(city1RawLong[1]);
                    
                    System.out.printf("Lat Min: %d Lat Degree: %d", city1LatMin, city1LatDegrees);
                    System.out.printf("Long Min: %d Long Degree: %d", city1LongMin, city1LongDegrees);
                }
                if(sourceLine.matches(city2 + ".*"))
                {
                    city2Source = sourceLine.split(":");
                    for(String inspect: city2Source){
                        System.out.printf("%s\n", inspect);
                    }
                    city2RawLat = city2Source[2].split("\\D+");
                    city2RawLong = city2Source[3].split("\\D+");
                    
                    city2LatDegrees = Integer.parseInt(city2RawLat[0]);
                    city2LatMin = Integer.parseInt(city2RawLat[1]);
                    city2LongDegrees = Integer.parseInt(city2RawLong[0]);
                    city2LongMin = Integer.parseInt(city2RawLong[1]);
                    
                    System.out.printf("Lat Min: %d Lat Degree: %d", city2LatMin, city2LatDegrees);
                    System.out.printf("Long Min: %d Long Degree: %d", city2LongMin, city2LongDegrees);
                }
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
