package mixedcontent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
//https://www.codeeval.com/open_challenges/115/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] data;
		while ((line = in.readLine()) != null) {
			data = line.split(",");
			StringBuilder nums = new StringBuilder();
			StringBuilder words = new StringBuilder();
			
			for (int i = 0; i < data.length; i++) {
				if (isNumeric(data[i])) {
					nums.append(data[i] + ",");
				} else {
					words.append(data[i] + ",");
				}
			}
			
			if (words.length() == 0) {
				nums.deleteCharAt(nums.length() - 1);
				System.out.println(nums.toString());
			} else if (nums.length() == 0) {
				words.deleteCharAt(words.length() - 1);
				System.out.println(words.toString());
			} else {
				nums.deleteCharAt(nums.length() - 1);
				words.deleteCharAt(words.length() - 1);
				System.out.println(words.toString() + "|" + nums.toString());
			}
		}
		
		in.close();
	}
	
	static boolean isNumeric(String s) {
		try {
			int i = Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
