package simplesorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

//https://www.codeeval.com/open_challenges/91/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		StringBuilder sb;
		String line;
		String[] eles;
		float[] nums;
		while ((line = in.readLine()) != null) {
			eles = line.split("\\s");
			nums = new float[eles.length];
			sb = new StringBuilder();
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Float.parseFloat(eles[i]);
			}
			
			Arrays.sort(nums);
			
			for (int i = 0; i < nums.length; i++) {
				sb.append(String.format("%.3f", nums[i]) + " ");
			}
			
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		
		in.close();
	}
}