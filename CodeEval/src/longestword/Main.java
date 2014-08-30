package longestword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			String longest = "";
			List<String> words = new ArrayList<String>();
			words.addAll(Arrays.asList(line.split("\\s+")));
			
			for (String s : words) {
				if (s.length() > longest.length()) {
					longest = s;
				}
			}
			
			System.out.println(longest);
		}
		
		in.close();
		System.out.print("\n");
	}
}