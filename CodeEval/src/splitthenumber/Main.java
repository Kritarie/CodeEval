package splitthenumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/131/
	
	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    String[] input;
	    int left, right, breakIndex;
	    while ((line = in.readLine()) != null) {
	    	input = line.split("\\s");
	    	breakIndex = input[1].indexOf("+");
	    	if (breakIndex == -1) {
	    		breakIndex = input[1].indexOf("-");
	    		left = Integer.parseInt(input[0].substring(0, breakIndex));
	    		right = Integer.parseInt(input[0].substring(breakIndex));
	    		System.out.println(left - right);
	    	} else {
	    		left = Integer.parseInt(input[0].substring(0, breakIndex));
	    		right = Integer.parseInt(input[0].substring(breakIndex));
	    		System.out.println(left + right);
	    	}
	    }
	    
	    in.close();
	}
}
