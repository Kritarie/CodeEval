package numberpairs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/34/
	
	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    String[] input;
	    int x;
	    int[] nums;
	    while ((line = in.readLine()) != null) {
	    	x = Integer.parseInt(line.substring(line.indexOf(';')+1,line.length()));
	    	input = line.substring(0, line.indexOf(';')).split(",");
	    	nums = new int[input.length];
	    	
	    	//Convert string array to int array
	    	for (int i = 0; i < input.length; i++) {
	    		nums[i] = Integer.parseInt(input[i]);
	    	}
	    	
	    	System.out.println(getPairs(nums, x));
	    }
	    
	    in.close();
	}

	private static String getPairs(int[] nums, int x) {
		StringBuilder sb = new StringBuilder();
		int i = 0, j = nums.length - 1, sum;
		while (true) {
			sum = nums[i] + nums[j];
			//Found a pair
			if (sum == x) {
				sb.append(nums[i] + "," + nums[j] + ";");
				i++;
//				j--;
			} else { //Check which pointer to increment/decrement
				if (sum > x) {
					j--;
				} else {
					i++;
				}
			}
			//When pointers cross, break loop
			if (i > j) {
				break;
			}
		}
		//No pairs found
		if (sb.length() == 0) {
			return "NULL";
		}
		//Remove trailing semicolon
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
