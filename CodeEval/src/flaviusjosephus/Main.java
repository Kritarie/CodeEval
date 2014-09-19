package flaviusjosephus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/75/

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		in.useDelimiter("\\D");
		StringBuilder sb;
		int n, m, index;
		List<Integer> deathRow = new ArrayList<Integer>();
		while (in.hasNext()) {
			n = in.nextInt();
			m = in.nextInt();
			index = 0;
			sb = new StringBuilder();
			
			//populate deathrow
			for (int i = 0; i < n; i++) {
				deathRow.add(i);
			}
			
			//Execute
			while (!deathRow.isEmpty()) {
				for (int i = 0; i < m-1; i++) {
					index++;
					if (index >= deathRow.size()) {
						index = 0;
					}
				}
				
				sb.append(deathRow.remove(index) + " ");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		
		in.close();
	}
}
