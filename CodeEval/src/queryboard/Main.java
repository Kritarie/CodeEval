package queryboard;

//https://www.codeeval.com/open_challenges/87/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    String[] command;
	    int[][] board = new int[256][256];
	    while ((line = in.readLine()) != null) {
	    	command = line.split("\\s+");
	    	switch(command[0]) {
	    	case "SetCol":
	    		setCol(board, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
	    		break;
	    	case "SetRow":
	    		setRow(board, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
	    		break;
	    	case "QueryCol":
	    		System.out.println(queryCol(board, Integer.parseInt(command[1])));
	    		break;
	    	case "QueryRow":
	    		System.out.println(queryRow(board, Integer.parseInt(command[1])));
	    		break;
	    	default:
	    		break;
	    	}
	    }
	    
	    in.close();
	}
	
	private static void setCol(int[][] b, int j, int x) {
		for (int i = 0; i < b.length; i++) {
			b[i][j] = x;
		}
	}
	
	private static void setRow(int[][] b, int i, int x) {
		for (int j = 0; j < b.length; j++) {
			b[i][j] = x;
		}
	}
	
	private static int queryCol(int[][] b, int j) {
		int x = 0;
		for (int i = 0; i < b.length; i++) {
			x += b[i][j];
		}
		return x;
	}
	
	private static int queryRow(int[][] b, int i) {
		int x = 0;
		for (int j = 0; j < b.length; j++) {
			x += b[i][j];
		}
		return x;
	}
}
