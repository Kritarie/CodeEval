package jugglingzeros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/149/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] zeros;
		StringBuilder sb;
		while ((line = in.readLine()) != null) {
			zeros = line.split("\\s");
			sb = new StringBuilder();
			for (int i = 0; i < zeros.length; i += 2) {
				if (zeros[i].equals("0")) {
					//append the following zeros
					sb.append(zeros[i+1]);
				} else {
					//append a 1 for each 0 in the following sequence
					for (int x = 0; x < zeros[i+1].length(); x++) {
						sb.append(1);
					}
				}
			}
			
			System.out.println(toDecimal(sb.toString()));
		}
		
		in.close();
	}

	private static int toDecimal(String line) {
		int num = 0;
		for (int i = 0; i < line.length(); i++) {
			num += (Character.getNumericValue(line.charAt(line.length() - 1 - i)) * Math.pow(2, i));
		}
		return num;
	}
}
