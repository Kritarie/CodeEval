package swapelements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/112/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			String[] split = line.split("\\s*:\\s*");
			String[] list = split[0].split("\\s+");
			String[] positions = split[1].split("\\s*,\\s*");
			//Strings in positions[] are in the form "a-b" at this point, so get char at pos 0 and 2
			for (int i = 0; i < positions.length; i++) {
				String[] swaps = positions[i].split("\\-");
				swap(list, Integer.parseInt(swaps[0]), Integer.parseInt(swaps[1]));
			}
			
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
		}
		
		in.close();
	}
	
	public static void swap(String[] array, int a, int b) {
		String temp;
		temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}