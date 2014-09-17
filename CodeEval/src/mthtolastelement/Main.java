package mthtolastelement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/10/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		int m;
		String[] input;
		while ((line = in.readLine()) != null) {
			input = line.split("\\s");
			m = Integer.parseInt(input[input.length - 1]);
			if (m < 1 || m > input.length - 1) continue;
			System.out.println(input[input.length - m - 1]);
		}
		
		in.close();
	}
}
