package readmore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		String line, trimmed;
		while ((line = in.readLine()) != null) {
			if (line.length() <= 55) {
				System.out.println(line);
			} else {
				trimmed = line.substring(0, 39);
				if (trimmed.contains(" ")) {
					trimmed = trimmed.substring(0, trimmed.lastIndexOf(" ")).trim();
				}
				System.out.println(trimmed + "... <Read More>");
			}
		}
		in.close();
	}

}
