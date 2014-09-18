package pascalstriangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/66/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		while (in.hasNext()) {
			printPascal(in.nextInt());
		}
		
		in.close();
	}

	private static void printPascal(int n) {
		StringBuilder sb = new StringBuilder();
		int[] previousRow = { 1 };
		sb.append(1 + " ");
		int[] currentRow;
		for (int i = 1; i < n; i++) {
			currentRow = new int[previousRow.length + 1];
			//Populate current row by summing adjacent elements in prev row
			for (int j = 0; j < currentRow.length; j++) {
				try {
					currentRow[j] = previousRow[j-1] + previousRow[j];
				} catch (ArrayIndexOutOfBoundsException e) {
					currentRow[j] = 1;
				}
			}
			
			for (int x = 0; x < currentRow.length; x++) {
				sb.append(currentRow[x] + " ");
			}
			previousRow = currentRow;
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}
}