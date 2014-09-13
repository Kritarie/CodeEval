package firstnonrepeatchar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/12/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				if (!isRepeated(line.charAt(i), line)) {
					System.out.println(line.charAt(i));
					break;
				}
			}
		}
		
		in.close();
	}

	private static boolean isRepeated(char x, String s) {
		int numOccurences = 0;
		for (int i = 0; i < s.length(); i++) {
			if (x == s.charAt(i)) {
				if (++numOccurences > 1) {
					return true;
				}
			}
		}
		return false;
	}
}