package fibonacciseries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/22/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int n;
		while (in.hasNext()) {
			n = in.nextInt();
			System.out.println(fibonacci(n));
		}
		
		in.close();
	}
	//In order to understand recursion, you must first understand recursion.
	private static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}