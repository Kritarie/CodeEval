package rollercoaster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/156/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		char[] letters;
		int currentLetter;
		while ((line = in.readLine()) != null) {
			letters = line.toCharArray();
			currentLetter = 0;
			
			for (int i = 0; i < letters.length; i++) {
				if (Character.isAlphabetic(letters[i])) {
					if (currentLetter % 2 == 0) {
						letters[i] = Character.toUpperCase(letters[i]);
						currentLetter++;
					} else {
						letters[i] = Character.toLowerCase(letters[i]);
						currentLetter++;
					}
				}
			}
			
			System.out.println(new String(letters));
		}
		
		in.close();
	}
}