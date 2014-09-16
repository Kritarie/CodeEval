package sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/78/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		Board board;
		int[][] data;
		Scanner scan;
		int n;
		while ((line = in.readLine()) != null) {
			n = Character.getNumericValue(line.charAt(0));
			data = new int[n][n];
			scan = new Scanner(line.substring(2));
			scan.useDelimiter(",");
			
			//Populate data for board
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					data[i][j] = scan.nextInt();
				}
			}
			
			board = new Board(n, data);
			System.out.println(board.isValid() ? "True" : "False");
		}
		
		in.close();
	}
}

class Board {
	private int[][] array;
	private final int SUM, n;
	
	public Board(int n, int[][] array) {
		this.n = n;
		this.array = array;
		
		//Calc required row/column/square sum
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum+= i;
		}
		SUM = sum;
	}

	public boolean isValid() {
		return (rowsValid() && columnsValid() && squaresValid());
	}
	
	private boolean rowsValid() {
		int sum;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				sum += array[i][j]; 
			}
			if (sum != SUM) return false;
		}
		return true;
	}
	
	private boolean columnsValid() {
		int sum;
		for (int j = 0; j < n; j++) {
			sum = 0;
			for (int i = 0; i < n; i++) {
				sum += array[i][j]; 
			}
			if (sum != SUM) return false;
		}
		return true;
	}
	
	private boolean squaresValid() {
		int subn = (int) Math.sqrt(n);
		int subi = 0, subj = 0;
		
		SubBoard[][] subBoards = new SubBoard[subn][subn];
		
		//Create subboards
		for (int i = 0; i < n; i += subn) {
			subj = 0;
			for (int j = 0; j < n; j += subn) {
				subBoards[subi][subj] = this.getSubBoard(subn, i, j);
				if (!subBoards[subi][subj].isValid()) return false;
				subj++;
			}
			subi++;
		}
		
		return true;
	}

	private SubBoard getSubBoard(int subn, int i, int j) {
		int[][] temp = new int[subn][subn];
		for (int a = 0; a < subn; a++) {
			for (int b = 0; b < subn; b++) {
				temp[a][b] = array[i+a][j+b];
			}
		}
		return new SubBoard(subn, temp);
	}
}

class SubBoard {
	
	private int[][] array;
	private final int SUM, n;

	public SubBoard(int n, int[][] array) {
		this.n = n;
		this.array = array;
		
		//Calc required sum of subBoard
		int sum = 0;
		for (int i = 1; i <= n*n; i++) {
			sum+= i;
		}
		SUM = sum;
	}
	
	public boolean isValid() {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				sum += array[i][j]; 
			}
		}
		return sum == SUM;
	}
}