package reversewords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/8/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] words;
		StringBuilder sb;
		while ((line = in.readLine()) != null) {
			words = line.split("\\s");
			sb = new StringBuilder();
			for (int i = words.length - 1; i >= 0; i--) {
				sb.append(words[i] + " ");
			}
			
			System.out.println(sb.toString().trim());
		}
		
		in.close();
	}
}
