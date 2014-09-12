package roadtrip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

//https://www.codeeval.com/open_challenges/124/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] cities;
		int[] distances;
		StringBuilder sb;
		while ((line = in.readLine()) != null) {
			cities = line.split(";");
			distances = new int[cities.length];
			for (int i = 0; i < cities.length; i++) {
				distances[i] = Integer.parseInt(cities[i].substring(cities[i].indexOf(",") + 1));
			}
			
			Arrays.sort(distances);
			sb = new StringBuilder();
			sb.append(distances[0] + ",");
			for (int i = 1; i < distances.length; i++) {
				sb.append((distances[i] - distances[i-1]) + ",");
			}
			
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		
		in.close();
	}
}
