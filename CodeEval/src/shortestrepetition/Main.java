package shortestrepetition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//https://www.codeeval.com/open_challenge_scores/?pkbid=107

public class Main {

	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	    	for (int i = 1; i <= line.length(); i++) {
	    		if (isRepeated(line.substring(0, i), line)) {
	    			System.out.println(i);
	    			break;
	    		}
	    	}
	    }
	    
	    in.close();
	    System.out.print("\n");
	}
	
	private static boolean isRepeated(String sub, String og) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.append(sub);
			if (og.equalsIgnoreCase(sb.toString())) {
				return true;
			}
			
			if (sb.toString().length() > og.length()) {
				return false;
			}
		}
	}
}
