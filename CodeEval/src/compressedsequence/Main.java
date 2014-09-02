package compressedsequence;

//https://www.codeeval.com/open_challenges/128/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] uncompressed;
		while ((line = in.readLine()) != null) {
			uncompressed = line.split("\\s+");
			System.out.println(compress(uncompressed));
		}
		
		in.close();
	}

	private static String compress(String[] s) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		String current = s[0];
		for (int i = 1; i < s.length; i++) {
			if (s[i].equals(current)) {
				count++;
			} else {
				sb.append(count + " " + current + " ");
				count = 1;
				current = s[i];
			}
		}
		//Grab the last sequence
		sb.append(count + " " + current);
		
		return sb.toString();
	}
}
