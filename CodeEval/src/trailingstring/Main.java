package trailingstring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/32/
	
	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line, A, B;
	    while ((line = in.readLine()) != null) {
	    	A = line.substring(0, line.indexOf(","));
	    	B = line.substring(line.indexOf(",")+1, line.length());
	    	
	    	System.out.println(isTrailing(A, B));
	    }
	    
	    in.close();
	}

	private static int isTrailing(String A, String B) {
		//Test for B length > A length
		if (B.length() > A.length()) {
			return 0;
		}
		
		if (A.substring(A.length() - B.length()).equals(B)) {
			return 1;
		} else {
			return 0;
		}
	}
}
