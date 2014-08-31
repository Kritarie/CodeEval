package hextodecimal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/67/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		
		int num;
		while ((line = in.readLine()) != null) {
			num = 0;
			for (int i = 0; i < line.length(); i++) {
				num += (Character.getNumericValue(line.charAt(line.length() - 1 - i)) * Math.pow(16, i));
			}
			System.out.println(num);
		}
		
		in.close();
	}
}