package wordtodigit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

//https://www.codeeval.com/open_challenges/104/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] nums;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		
		while ((line = in.readLine()) != null) {
			nums = line.split(";");
			for (int i = 0; i < nums.length; i++) {
				System.out.print(map.get(nums[i]));
			}
			System.out.println();
		}
		
		in.close();
	}
}
