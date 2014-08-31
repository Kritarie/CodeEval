package agedistribution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/152/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int num;
		while (in.hasNext()) {
			num = in.nextInt();
			
			if (num >= 0 && num <= 2) {
				System.out.println("Still in Mama's arms");
			} else if (num >= 3 && num <= 4) {
				System.out.println("Preschool Maniac");
			} else if (num >= 5 && num <= 11) {
				System.out.println("Elementary school");
			} else if (num >= 12 && num <= 14) {
				System.out.println("Middle school");
			} else if (num >= 15 && num <= 18) {
				System.out.println("High school");
			} else if (num >= 19 && num <= 22) {
				System.out.println("College");
			} else if (num >= 23 && num <= 65) {
				System.out.println("Working for the man");
			} else if (num >= 66 && num <= 100) {
				System.out.println("The Golden Years");
			} else {
				System.out.println("This program is for humans");
			}
		}
		
		in.close();
		System.out.print("\n");
	}
}