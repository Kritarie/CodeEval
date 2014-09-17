package sumofintegers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/17/
	
	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    String[] input;
	    int[] nums;
	    while ((line = in.readLine()) != null) {
	    	input = line.split(",");
	    	//Convert string array to ints
	    	nums = new int[input.length];
	    	for (int i = 0; i < nums.length; i++) {
	    		nums[i] = Integer.parseInt(input[i].trim());
	    	}
	    	
	    	System.out.println(largestSum(nums));
	    }
	    
	    in.close();
	}

	private static int largestSum(int[] nums) {
	    int largest = -Integer.MAX_VALUE;
	    int temp;
	    for (int i = 0; i < nums.length; i++) {
	    	for (int j = i; j < nums.length; j++) {
	     		temp = sumSubArray(nums, i, j);
	     		if (temp > largest) {
	     			largest = temp;
	     		}
	    	}
	    }
	    return largest;
	}

	private static int sumSubArray(int[] nums, int i, int j) {
		int sum = 0;
		for (int x = i; x <= j; x++) {
			sum += nums[x];
		}
		return sum;
	}
}
