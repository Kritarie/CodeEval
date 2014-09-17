package removecharacters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/13/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] input;
		while ((line = in.readLine()) != null) {
			input = line.split(",(\\s*)");
			for (int i = 0; i < input[1].length(); i++) {
				input[0] = input[0].replace(input[1].substring(i, i+1), "");
			}
			System.out.println(input[0].trim());
		}
		
		in.close();
	}
}
