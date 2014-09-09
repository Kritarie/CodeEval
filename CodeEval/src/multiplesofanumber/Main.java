package multiplesofanumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/18/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String input;
		String[] nums;
		int x, n, total;
		while ((input = in.readLine()) != null) {
			total = 0;
			nums = input.split(",");
			x = Integer.parseInt(nums[0]);
			n = Integer.parseInt(nums[1]);
			
			while (x >= total) {
				total += n;
			}
			
			System.out.println(total);
		}
		
		in.close();
	}
}