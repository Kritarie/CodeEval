package datarecovery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

//https://www.codeeval.com/open_challenges/140/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		StringBuilder sb;
		String[] words, recovered;
		String[] eles, nums;
		int[] vals;
		int missingIndex;
		while ((line = in.readLine()) != null) {
			eles = line.split(";");
			
			//get num array from hint
			nums = eles[1].split("\\s");
			vals = new int[nums.length];
			for (int i = 0; i < vals.length; i++) {
				vals[i] = Integer.parseInt(nums[i]);
			}
			
			//get word array to reorder
			words = eles[0].split("\\s");
			recovered = new String[words.length];
			
			//Recover data
			for (int i = 0; i < vals.length; i++) {
				recovered[vals[i] - 1] = words[i];
			}
			
			//Find the missing word
			missingIndex = findMissingNum(vals);
			recovered[missingIndex] = words[words.length - 1];
			
			//Print data
			sb = new StringBuilder();
			for (int i = 0; i < recovered.length; i++) {
				sb.append(recovered[i] + " ");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		
		in.close();
	}

	private static int findMissingNum(int[] vals) {
		Arrays.sort(vals);
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] == i+1) {
				continue;
			} else {
				return i;
			}
		}
		return vals.length;
	}
}