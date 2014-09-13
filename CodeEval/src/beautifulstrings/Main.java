package beautifulstrings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	//https://www.codeeval.com/open_challenges/83/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			System.out.println(getBeauty(line));
		}

		in.close();
	}
	
	private static int getBeauty(String s) {
		Map<Character, Integer> occurences = new HashMap<Character, Integer>();
		//Populate our character occurence map
		for (int i = 0; i < s.length(); i++) {
			Character c = Character.toLowerCase(s.charAt(i));
			if (c < 'a' || c > 'z') {
				continue;
			}
			
			Integer occurence = occurences.get(c);
			if (occurence == null) {
				occurence = 1;
			} else {
				occurence++;
			}
			
			occurences.put(c, occurence);
		}
		
		//Convert map to list for sorting
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Character letter : occurences.keySet()) {
			list.add(occurences.get(letter));
		}
		
		Collections.sort(list);
		
		//Calculate sum by iterating over the occurences list
		int beauty = 26;
		int sum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			sum += beauty*list.get(i);
			beauty--;
		}
		return sum;
	}
}
