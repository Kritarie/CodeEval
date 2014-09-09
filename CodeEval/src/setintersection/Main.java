package setintersection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
//https://www.codeeval.com/open_challenges/30/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] sets, left, right;
		StringBuilder sb;
		List<Integer> leftSet, rightSet;
		while ((line = in.readLine()) != null) {
			sb = new StringBuilder();
			sets = line.split(";");
			left = sets[0].split(",");
			right = sets[1].split(",");
			
			leftSet = new ArrayList<Integer>();
			rightSet = new ArrayList<Integer>();
			
			//Populate the left list
			for (int i = 0; i < left.length; i++) {
				leftSet.add(Integer.parseInt(left[i]));
			}
			
			//Populate the right list
			for (int i = 0; i < right.length; i++) {
				rightSet.add(Integer.parseInt(right[i]));
			}
			
			//Compare left to right
			for (int i : leftSet) {
				if (rightSet.contains(i)) {
					sb.append(leftSet.get(leftSet.indexOf(i)) + ",");
				}
			}
			
			if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			
			System.out.println(sb.toString());
		}
		
		in.close();
	}

}