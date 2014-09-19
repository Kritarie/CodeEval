package pointincircle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/98/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] splitInput;
		double centerX, centerY;
		double radius;
		double pointX, pointY;
		double distance;
		while ((line = in.readLine()) != null) {
			splitInput = line.split(";");
			//Parse line
			centerX = Double.parseDouble(splitInput[0].substring(
					splitInput[0].indexOf('(')+1, splitInput[0].indexOf(',')));
			centerY = Double.parseDouble(splitInput[0].substring(
					splitInput[0].indexOf(',')+1, splitInput[0].indexOf(')')));
			radius = Double.parseDouble(splitInput[1].substring(
					splitInput[1].indexOf(':')+1));
			pointX = Double.parseDouble(splitInput[2].substring(
					splitInput[2].indexOf('(')+1, splitInput[2].indexOf(',')));
			pointY = Double.parseDouble(splitInput[2].substring(
					splitInput[2].indexOf(',')+1, splitInput[2].indexOf(')')));
			
			//Calculate distance of point from center, compare to radius
			distance = Math.sqrt(Math.pow(centerX - pointX, 2) + 
								Math.pow(centerY - pointY, 2));
			System.out.println(radius > distance);
		}
		
		in.close();
	}
}
