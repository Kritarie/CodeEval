package majorelement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

//https://www.codeeval.com/open_challenges/132/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] eles;
		int[] nums;
		while ((line = in.readLine()) != null) {
			eles = line.split(",");
			nums = new int[eles.length];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(eles[i]);
			}
			Arrays.sort(nums);
			
			for (int i = 0; i < nums.length/2; i++) {
				if (nums[i] == nums[i + nums.length/2]) {
					System.out.println(nums[i]);
					break;
				}
				if (i == nums.length/2 - 1) {
					System.out.println("None");
				}
			}
		}
		
		in.close();
	}
}
