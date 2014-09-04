package findingprimes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//https://www.codeeval.com/open_challenges/46/

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int N;
		while (in.hasNext()) {
			N = in.nextInt();
			StringBuilder sb = new StringBuilder();
			for (int i = 2; i < N; i++) {
				if (isPrime(i)) {
					sb.append(i + ",");
				}
			}
			//remove last comma
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		
		in.close();
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt((double)num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}