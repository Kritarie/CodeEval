package apileofbricks;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/117/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		Scanner scan;
		Rectangle hole;
		List<Brick> bricks;
		StringBuilder sb;
		while ((line = in.readLine()) != null) {
			line = line.replaceAll("[^-0-9]", " ");
			bricks = new ArrayList<Brick>();
			scan = new Scanner(line);
			int x, y;
			x = scan.nextInt();
			y = scan.nextInt();
			hole = new Rectangle(Math.abs(x - scan.nextInt()), Math.abs(y - scan.nextInt()));
			
			//Scan and add bricks
			while (scan.hasNext()) {
				bricks.add(new Brick(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), 
						scan.nextInt(), scan.nextInt(), scan.nextInt()));
			}
			
			//Add bricks that fit to string
			sb = new StringBuilder();
			for (Brick b : bricks) {
				sb.append(b.canFit(hole) ? b.getId() + "," : "");
			}
			
			try {
				sb.deleteCharAt(sb.length() - 1);
			} catch (StringIndexOutOfBoundsException e) {
				sb.append("-");
			}
			
			System.out.println(sb.toString());
		}
		in.close();
	}
}

class Brick {
	private int id;
	private int leftX;
	private int leftY;
	private int leftZ;
	private int rightX;
	private int rightY;
	private int rightZ;
	
	public Brick(int id, int leftX, int leftY, int leftZ,
						int rightX, int rightY, int rightZ) {
		this.id = id;
		this.leftX = leftX;
		this.leftY = leftY;
		this.leftZ = leftZ;
		this.rightX = rightX;
		this.rightY = rightY;
		this.rightZ = rightZ;
	}
	
	public int getId() {
		return id;
	}

	public boolean canFit(Rectangle h) {
		if (testXY(h) || testXZ(h) || testYZ(h)) return true;
		return false;
	}
	
	private boolean testXY(Rectangle h) {
		Rectangle xy = new Rectangle(Math.abs(leftX - rightX), Math.abs(leftY - rightY));
		Rectangle yx = new Rectangle(Math.abs(leftY - rightY), Math.abs(leftX - rightX));
		return h.contains(xy) || h.contains(yx) ? true : false;
	}
	
	private boolean testXZ(Rectangle h) {
		Rectangle xz = new Rectangle(Math.abs(leftX - rightX), Math.abs(leftZ - rightZ));
		Rectangle zx = new Rectangle(Math.abs(leftZ - rightZ), Math.abs(leftX - rightX));
		return h.contains(xz) || h.contains(zx) ? true : false;
	}
	
	private boolean testYZ(Rectangle h) {
		Rectangle yz = new Rectangle(Math.abs(leftY - rightY), Math.abs(leftZ - rightZ));
		Rectangle zy = new Rectangle(Math.abs(leftZ - rightZ), Math.abs(leftY - rightY));
		return h.contains(yz) || h.contains(zy) ? true : false;
	}
}