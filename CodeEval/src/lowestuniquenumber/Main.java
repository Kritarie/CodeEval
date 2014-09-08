package lowestuniquenumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/103/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] input;
		int[] nums;
		while ((line = in.readLine()) != null) {
			input = line.split("\\s");
			nums = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				nums[i] = Integer.parseInt(input[i]);
			}
			
			for (int i = 0; i < 10; i++) {
				if (numOccurences(i, nums) == 1) {
					System.out.println(positionOf(i, nums) + 1);
					break;
				}
				if (i == 9) {
					System.out.println(0);
				}
			}
		}
		
		in.close();
	}

	private static int positionOf(int x, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (x == nums[i]) {
				return i;
			}
		}
		return 0;
	}

	private static int numOccurences(int x, int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (x == nums[i]) {
				count++;
			}
		}
		return count;
	}
}