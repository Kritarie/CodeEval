package armstrongnumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

//https://www.codeeval.com/open_challenges/82/

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int num;
		while (in.hasNext()) {
			num = in.nextInt();
			if (num == armstrongify(num)) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
		
		in.close();
	}
	
	private static int armstrongify(int n) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int power = String.valueOf(n).length();
		while (n > 0) {
			stack.push(n % 10);
			n = n / 10;
		}
		n = 0;
		while (!stack.isEmpty()) {
			n += (int) Math.pow(stack.pop(), power);
		}
		return n;
	}
}