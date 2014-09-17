package stringrotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/76/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] input;
		while ((line = in.readLine()) != null) {
			input = line.split(",");
			System.out.println(isRotation(input[0], input[1]) ? "True" : "False");
		}
		
		in.close();
	}
	
	private static boolean isRotation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		
		for (int i = 0; i < b.length(); i++) {
			b = shift(b);
			if (b.equals(a)) {
				return true;
			}
		}
		
		return false;
	}
	
	private static String shift(String s) {
		StringBuilder sb = new StringBuilder();
		//Append last character to the front
		sb.append(s.charAt(s.length() - 1));
		//Append the rest
		for (int i = 0; i < s.length() - 1; i++) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
