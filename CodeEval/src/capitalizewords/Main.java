package capitalizewords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] sentence;
		while ((line = in.readLine()) != null) {
			sentence = line.split("\\s");
			for (int i = 0; i < sentence.length; i++) {
				System.out.print(capitalize(sentence[i]) + " ");
			}
			System.out.println();
		}
		
		in.close();
	}
	
	static String capitalize(String s)
	{
	  return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}
}
