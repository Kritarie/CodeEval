package fizzbuzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main (String[] args) throws NumberFormatException, IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");
			if (lineArray.length > 0) {
				//Process line of input Here
				int A = Integer.parseInt(lineArray[0]);
				int B = Integer.parseInt(lineArray[1]);
				int N = Integer.parseInt(lineArray[2]);

				for (int i = 1; i <= N; i++) {
					if (i % A == 0 && i % B == 0) {
						System.out.print("FB");
					} else if (i % A == 0) {
						System.out.print("F");
					} else if (i % B == 0) {
						System.out.print("B");
					} else {
						System.out.print(i);
					}

					if (i != N) {
						System.out.print(" ");
					}
				}
				
				System.out.print("\n");
			}
		}
		
		in.close();
	}
}