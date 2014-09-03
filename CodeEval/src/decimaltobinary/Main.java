package decimaltobinary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/27/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int num;
		while (in.hasNext()) {
			num = in.nextInt();
			System.out.println(num == 0 ? 0 : toBinary(num));
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