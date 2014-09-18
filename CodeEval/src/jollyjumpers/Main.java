package jollyjumpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

//https://www.codeeval.com/open_challenges/43/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int n;
		int[] nums;
		while (in.hasNext()) {
			n = in.nextInt();
			nums = new int[n];
			//Populate number sequence array
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			
			System.out.println(isJolly(nums) ? "Jolly" : "Not jolly");
		}
		
		in.close();
	}

	private static boolean isJolly(int[] nums) {
		//Create list of all possible ints 1 to n-1
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < nums.length; i++) {
			set.add(i);
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			set.remove((int)Math.abs(nums[i] - nums[i+1]));
		}
		
		return set.isEmpty();
	}
}
