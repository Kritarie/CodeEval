package modwithoutmod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/62/
	
	public static void main(String[] args) throws IOException {
		File file = new File("txts\\modwithoutmod.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			String[] vals = line.split(",");
			System.out.println(mod(Integer.parseInt(vals[0]), Integer.parseInt(vals[1])));
			//System.out.println("with: " + Integer.parseInt(vals[0]) % Integer.parseInt(vals[1]));
		}
		
		in.close();
	}
	
	private static int mod(int N, int M) {
		int temp = 0;
		if (N <= M) {
			return N;
		}
		while (M <= N) {
			temp = N - M;
			N -= M;
		}
		return temp;
	}
}