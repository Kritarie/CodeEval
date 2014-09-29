package bigdigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/163/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		char[] array;
		String[] temp;
		StringBuilder[] sbs;
		while ((line = in.readLine()) != null) {
			line = line.replaceAll("\\D", "");
			array = line.toCharArray();
			
			sbs = new StringBuilder[6];
			
			//Initialize stringbuilders
			for (int i = 0; i < sbs.length; i++) {
				sbs[i] = new StringBuilder();
			}
			
			//Break down chars
			for (char c : array) {
				temp = getBigDigits(c);
				for (int i = 0; i < temp.length; i++) {
					sbs[i].append(temp[i]);
				}
			}
			
			//Print StringBuilders
			for (StringBuilder sb : sbs) {
				System.out.println(sb.toString());
			}
		}
		
		in.close();
	}

	private static String[] getBigDigits(char c) {
		String[] bigDigit = new String[6];
		switch (c) {
		case '0':
			bigDigit[0] = "-**--";
			bigDigit[1] = "*--*-";
			bigDigit[2] = "*--*-";
			bigDigit[3] = "*--*-";
			bigDigit[4] = "-**--";
			bigDigit[5] = "-----";
			return bigDigit;
		case '1':
			bigDigit[0] = "--*--";
			bigDigit[1] = "-**--";
			bigDigit[2] = "--*--";
			bigDigit[3] = "--*--";
			bigDigit[4] = "-***-";
			bigDigit[5] = "-----";
			return bigDigit;
		case '2':
			bigDigit[0] = "***--";
			bigDigit[1] = "---*-";
			bigDigit[2] = "-**--";
			bigDigit[3] = "*----";
			bigDigit[4] = "****-";
			bigDigit[5] = "-----";
			return bigDigit;
		case '3':
			bigDigit[0] = "***--";
			bigDigit[1] = "---*-";
			bigDigit[2] = "-**--";
			bigDigit[3] = "---*-";
			bigDigit[4] = "***--";
			bigDigit[5] = "-----";
			return bigDigit;
		case '4':
			bigDigit[0] = "-*---";
			bigDigit[1] = "*--*-";
			bigDigit[2] = "****-";
			bigDigit[3] = "---*-";
			bigDigit[4] = "---*-";
			bigDigit[5] = "-----";
			return bigDigit;
		case '5':
			bigDigit[0] = "****-";
			bigDigit[1] = "*----";
			bigDigit[2] = "***--";
			bigDigit[3] = "---*-";
			bigDigit[4] = "***--";
			bigDigit[5] = "-----";
			return bigDigit;
		case '6':
			bigDigit[0] = "-**--";
			bigDigit[1] = "*----";
			bigDigit[2] = "***--";
			bigDigit[3] = "*--*-";
			bigDigit[4] = "-**--";
			bigDigit[5] = "-----";
			return bigDigit;
		case '7':
			bigDigit[0] = "****-";
			bigDigit[1] = "---*-";
			bigDigit[2] = "--*--";
			bigDigit[3] = "-*---";
			bigDigit[4] = "-*---";
			bigDigit[5] = "-----";
			return bigDigit;
		case '8':
			bigDigit[0] = "-**--";
			bigDigit[1] = "*--*-";
			bigDigit[2] = "-**--";
			bigDigit[3] = "*--*-";
			bigDigit[4] = "-**--";
			bigDigit[5] = "-----";
			return bigDigit;
		case '9':
			bigDigit[0] = "-**--";
			bigDigit[1] = "*--*-";
			bigDigit[2] = "-***-";
			bigDigit[3] = "---*-";
			bigDigit[4] = "-**--";
			bigDigit[5] = "-----";
			return bigDigit;
		default:
			return null;
			}
	}
}
