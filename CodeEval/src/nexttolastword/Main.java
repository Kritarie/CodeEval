package nexttolastword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("nexttolastword.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		
		while ((line = in.readLine()) != null) {
			
		}
	}
}
