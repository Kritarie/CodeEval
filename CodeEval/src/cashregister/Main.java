package cashregister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

//https://www.codeeval.com/open_challenges/54/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] splitLine;
		double pp, ch;
		while ((line = in.readLine()) != null) {
			splitLine = line.split(";");
			pp = Double.parseDouble(splitLine[0]);
			ch = Double.parseDouble(splitLine[1]);
			
			System.out.println(getChange(pp, ch));
		}
		
		in.close();
	}

	private static String getChange(double pp, double ch) {
		if (pp > ch) {
			return "ERROR";
		}
		
		if (pp == ch) {
			return "ZERO";
		}
		
		
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.##");
		double change = Double.valueOf(df.format(ch - pp));
		while (change != 0) {
			while (change >= 100) {
				change -= 100;
				sb.append("ONE HUNDRED,");
			}
			while (change >= 50) {
				change -= 50;
				sb.append("FIFTY,");
			}
			while (change >= 20) {
				change -= 20;
				sb.append("TWENTY,");
			}
			while (change >= 10) {
				change -= 10;
				sb.append("TEN,");
			}
			while (change >= 5) {
				change -= 5;
				sb.append("FIVE,");
			}
			while (change >= 2) {
				change -= 2;
				sb.append("TWO,");
			}
			while (change >= 1) {
				change -= 1;
				sb.append("ONE,");
			}
			while (change >= 0.5) {
				change = Double.valueOf(df.format(change - 0.5));
				sb.append("HALF DOLLAR,");
			}
			while (change >= 0.25) {
				change = Double.valueOf(df.format(change - 0.25));
				sb.append("QUARTER,");
			}
			while (change >= 0.1) {
				change = Double.valueOf(df.format(change - 0.1));
				sb.append("DIME,");
			}
			while (change >= 0.05) {
				change = Double.valueOf(df.format(change - 0.05));
				sb.append("NICKEL,");
			}
			while (change >= 0.01) {
				change = Double.valueOf(df.format(change - 0.01));
				sb.append("PENNY,");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
