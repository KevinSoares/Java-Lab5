/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg5;

/**
 *
 * @author Kevin
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
	{
	  if(args.length < 2)
	  {
	    System.err.println("Usage: java -jar lab_5.jar infile outfile");
	    System.exit(99);
	  }

	  Cruncher dataManipulator = new Cruncher(args[0], args[1]);

	  dataManipulator.openFiles();
	  dataManipulator.findDistance();
	  dataManipulator.writeRecords();
	  dataManipulator.closeFiles();
	}
}
