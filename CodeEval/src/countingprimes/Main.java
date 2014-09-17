package countingprimes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/63/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] input;
		int sum, start, end;
		while((line = in.readLine()) != null) {
			input = line.split(",");
			start = Integer.parseInt(input[0]);
			end = Integer.parseInt(input[1]);
			sum = 0;
			
			for (int i = start; i <= end; i++) {
				sum += isPrime(i) ? 1 : 0;
			}
			
			System.out.println(sum);
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
