package aromaticnumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

//https://www.codeeval.com/open_challenges/150/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		int num, romanNum, sum;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		while ((line = in.readLine()) != null) {
			sum = 0;
			for (int i = 0; i < line.length(); i += 2) {
				num = Character.getNumericValue(line.charAt(i));
				romanNum = map.get(line.charAt(i+1));
				
				//Look ahead to check if add or subtract
				try {
					if (map.get(line.charAt(i+3)) > romanNum) {
						sum -= num*romanNum;
					} else {
						sum += num*romanNum;
					}
				} catch (StringIndexOutOfBoundsException e) {
					//If i+3 is out of bounds, this is our last pair, so add
					sum += num*romanNum;
				}
			}
			System.out.println(sum);
		}
		
		in.close();
	}
}
