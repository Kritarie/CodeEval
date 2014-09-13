package lettercasepercent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/147/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		char[] letters;
		double numLower, numUpper;
		while ((line = in.readLine()) != null) {
			numLower = 0;
			numUpper = 0;
			letters = line.toCharArray();
			for (int i = 0; i < letters.length; i++) {
				if (Character.isLowerCase(letters[i])) {
					numLower++;
				} else {
					numUpper++;
				}
			}
			
			System.out.println("lowercase: " + String.format("%.2f", ((numLower/letters.length)*100)) + 
					" uppercase: " + String.format("%.2f", ((numUpper/letters.length)*100)));
		}
		
		in.close();
	}
}