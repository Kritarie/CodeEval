package numberofonebits;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/16/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int num;
		String binary;
		while (in.hasNext()) {
			num = in.nextInt();
			binary = toBinary(num);
			System.out.println(numOnes(binary));
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
	
	static int numOnes(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.getNumericValue(s.charAt(i)) == 1) count++;
		}
		return count;
	}
}