package pangrams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

//https://www.codeeval.com/open_challenges/37/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
		List<Character> charList;
		while ((line = in.readLine()) != null) {
			charList = new LinkedList<Character>(Arrays.asList(alphabet));
			line = line.replaceAll("\\W", "").toLowerCase();
			for (Character c : line.toCharArray()) {
				charList.remove(c);
			}
			
			if (charList.isEmpty()) {
				System.out.print("NULL");
			} else {
				for (Character c : charList) {
					System.out.print(c);
				}
			}
			System.out.println();
		}
		
		in.close();
	}
}
