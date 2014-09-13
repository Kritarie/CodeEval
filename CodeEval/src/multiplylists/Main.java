package multiplylists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
//https://www.codeeval.com/open_challenges/113/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] sides, left, right;
		StringBuilder sb;
		while ((line = in.readLine()) != null) {
			sides = line.split("\\|");
			left = sides[0].split("\\s");
			right = sides[1].split("\\s");
			sb = new StringBuilder();
			
			for (int i = 0; i < left.length; i++) {
				sb.append(Integer.parseInt(left[i]) * Integer.parseInt(right[i+1]) + " ");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		
		in.close();
	}
}
