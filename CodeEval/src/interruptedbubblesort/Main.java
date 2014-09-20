package interruptedbubblesort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/158/

	static int[] array;
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] input;
		long iterations;
		StringBuilder sb;
		while ((line = in.readLine()) != null) {
			iterations = Long.parseLong(line.substring(line.indexOf('|')+2));
			input = line.substring(0, line.indexOf('|')).split("\\s");
			array = new int[input.length];
			
			//Convert to int array
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(input[i]);
			}
			
			//Avoid huge iteration count
			if (iterations > array.length) {
				iterations = array.length;
			}
			
			for (int i = 0; i < iterations; i++) {
				for (int j = 0; j < array.length - 1; j++) {
					if (array[j] > array[j+1]) {
						swap(j, j+1);
					}
				}
			}
			
			sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i] + " ");
			}
			
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
			
		}
		
		in.close();
	}
	private static void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
