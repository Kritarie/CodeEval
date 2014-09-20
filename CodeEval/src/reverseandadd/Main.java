package reverseandadd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/45/

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int n;
		while (in.hasNext()) {
			n = in.nextInt();
			
			System.out.println(reverseAndAdd(n));
		}
		
		in.close();
	}

	private static String reverseAndAdd(int n) {
		StringBuilder sb;
		int count = 0;
		while (!isPalindrome(n)) {
			count++;
			sb = new StringBuilder();
			sb.append(n);
			n += Integer.parseInt(sb.reverse().toString());
		}
		return count + " " + n;
	}

	static boolean isPalindrome(int num) {
		String str = String.valueOf(num);
		int n = str.length();
		for (int i = 0; i < n/2; i++) {
			if (str.charAt(i) != str.charAt(n - 1 - i)) return false;
		}
		return true;
	}
}
