package romannumerals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//https://www.codeeval.com/open_challenges/106/

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(new FileReader(file));
		int num;
		while (in.hasNext()) {
			StringBuilder sb = new StringBuilder();
			num = in.nextInt();
			
			//Check for M = 1000
			while (num >= 1000) {
				sb.append("M");
				num = num - 1000;
			}
			
			//Check for CM = 900
			if (num >= 900) {
				sb.append("CM");
				num = num - 900;
			}
			
			//Check for D = 500
			while (num >= 500) {
				sb.append("D");
				num = num - 500;
			}
			
			//Check for C = 100
			while (num >= 100) {
				sb.append("C");
				num = num - 100;
			}
			
			//Check for XC = 90
			if (num >= 90) {
				sb.append("XC");
				num = num - 90;
			}
			
			//Check for L = 50
			if (num >= 50) {
				sb.append("L");
				num = num - 50;
			}
			
			//Check for XL = 40
			if (num >= 40) {
				sb.append("XL");
				num = num - 40;
			}
			
			//Check for X = 10
			while (num >= 10) {
				sb.append("X");
				num = num - 10;
			}
			
			//Check for IX = 9
			if (num == 9) {
				sb.append("IX");
				num = num - 9;
			}
			
			//Check for V = 5
			if (num >= 5) {
				sb.append("V");
				num = num - 5;
			}
			
			//Check for IV = 4
			if (num == 4) {
				sb.append("IV");
				num = num - 4;
			}
			
			//Check for I = 1
			while (num >= 1) {
				sb.append("I");
				num--;
			}
			
			System.out.println(sb.toString());
		}
		
		in.close();
		System.out.print("\n");
	}
}
