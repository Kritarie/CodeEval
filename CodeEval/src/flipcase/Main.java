package flipcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	        StringBuilder flip = new StringBuilder(line);
	        for (int i = 0; i < flip.length(); i++) {
	        	char c = flip.charAt(i);
	        	if (Character.isLowerCase(c)) {
	        		flip.setCharAt(i, Character.toUpperCase(c));
	        	} else {
	        		flip.setCharAt(i, Character.toLowerCase(c));
	        	}
	        }
	        System.out.println(flip.toString());
	    }
	    in.close();
	    System.out.print("\n");
	}
}
