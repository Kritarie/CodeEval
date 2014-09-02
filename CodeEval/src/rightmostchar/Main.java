package rightmostchar;

//https://www.codeeval.com/open_challenges/31/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		char c;
		while ((line = in.readLine()) != null) {
			c = line.charAt(line.length() - 1);
			line = line.substring(0, line.length() - 2);
			for (int i = line.length() - 1; i >= 0; i--) {
				if (line.charAt(i) == c) {
					System.out.println(i);
					break;
				}
				if (i == 0) {
					System.out.println(-1);
				}
			}
		}
		
		in.close();
	}
}
