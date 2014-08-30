package hiddendigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//Map of what digits are hidden behind what characters
		map.put("a".charAt(0), 0);
		map.put("b".charAt(0), 1);
		map.put("c".charAt(0), 2);
		map.put("d".charAt(0), 3);
		map.put("e".charAt(0), 4);
		map.put("f".charAt(0), 5);
		map.put("g".charAt(0), 6);
		map.put("h".charAt(0), 7);
		map.put("i".charAt(0), 8);
		map.put("j".charAt(0), 9);
		while ((line = in.readLine()) != null) {
			char[] characters = line.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < characters.length; i++) {
				sb.append(map.containsKey(characters[i]) ? map.get(characters[i]) : "");
				sb.append(Character.isDigit(characters[i]) ? characters[i] : "");
			}
			if (sb.length() == 0) {
				System.out.print("NONE");
			}
			System.out.println(sb.toString());
		}
		
		in.close();
		System.out.print("\n");
	}
}
