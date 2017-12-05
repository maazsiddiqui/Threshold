/*
	Project 1.2: Threshold
	By: Maaz Siddiqui
*/

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		
		if (args.length < 1) return;
		
		threshold th = new threshold(args[0]);
		th.computeThreshold();
		th.printThreshold();
	}
	
}