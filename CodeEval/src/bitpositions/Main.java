package bitpositions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
	
//https://www.codeeval.com/open_challenges/19/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line, binary;
		String[] data;
		while ((line = in.readLine()) != null) {
			data = line.split(",");
			binary = toBinary(Integer.parseInt(data[0]));
			if (Character.getNumericValue(binary.charAt(binary.length() - Integer.parseInt(data[1]))) ==
					Character.getNumericValue(binary.charAt(binary.length() - Integer.parseInt(data[2])))) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
		
		in.close();
	}
	
	static String toBinary(int num) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (num > 0) {
			stack.push(num % 2);
			num /= 2;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
