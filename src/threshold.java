

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class threshold {
	
	private int[][] thArray;
	private int numRows;
	private int numCols;
	private int minVal;
	private int maxVal;
	private String inFile;
	private int thresholdVal;

	
	public threshold(String inFile) throws FileNotFoundException {
		
		this.inFile = inFile;
		
		Scanner dataFile = new Scanner(new File(inFile));
		
		numRows = dataFile.nextInt();
		numCols = dataFile.nextInt();
		minVal = dataFile.nextInt();
		maxVal = dataFile.nextInt();
	
		dataFile.close(); // input file closed
		
		thArray = new int[numRows][numCols];

	}
	
	public void computeThreshold() throws FileNotFoundException {
		
		Scanner reader = new Scanner(System.in);  
		System.out.print("Enter threshold number: ");
		thresholdVal = reader.nextInt(); 
				
		Scanner dataFile = new Scanner(new File(inFile));
		
		dataFile.nextLine();	// skip header line
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if(dataFile.nextInt() < thresholdVal) thArray[i][j] = 0;
				else thArray[i][j] = 1;
			}
		}
		
		dataFile.close();	// input file closed
		
	}
	
	public void printThreshold() throws IOException {
		
		maxVal = 0;
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if(thArray[i][j] < minVal) minVal = thArray[i][j];
				if(thArray[i][j] > maxVal) maxVal = thArray[i][j];
			}
		}
		
		PrintWriter out = new PrintWriter(new FileWriter("thr_" + thresholdVal + ".txt"));
		
		out.println(numRows + " " + numCols + " " + minVal + " " + maxVal);
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				out.print (thArray[i][j] + " ");
			}
			out.println();
		}

		out.close(); // output file closed
	}
}
