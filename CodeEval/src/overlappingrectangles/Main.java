package overlappingrectangles;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/70/
	
	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    String[] data;
	    while ((line = in.readLine()) != null) {
	    	data = line.split(",");
//	    	Rectangle one = new Rectangle(
//	    			new Point(Integer.parseInt(data[0]), Integer.parseInt(data[1])), 
//	    			new Point(Integer.parseInt(data[2]), Integer.parseInt(data[3])));
//	    	Rectangle two = new Rectangle(
//	    			new Point(Integer.parseInt(data[4]), Integer.parseInt(data[5])), 
//	    			new Point(Integer.parseInt(data[6]), Integer.parseInt(data[7])));
	    	
	    	Rectangle one = new Rectangle();
	    	one.add(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
	    	one.add(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
	    	
	    	Rectangle two = new Rectangle();
	    	two.add(Integer.parseInt(data[4]), Integer.parseInt(data[5]));
	    	two.add(Integer.parseInt(data[6]), Integer.parseInt(data[7]));
	    	
	    	if (one.intersects(two)) {
	    		System.out.println("True");
	    	} else {
	    		System.out.println("False");
	    	}
	    }
	    
	    in.close();
	}
}

//class Rectangle {
//	private Point upperLeft;
//	private Point lowerRight;
//	
//	public Rectangle(Point upperLeft, Point lowerRight) {
//		this.upperLeft = upperLeft;
//		this.lowerRight = lowerRight;
//	}
//	
//	public boolean intersects(Rectangle r) {
//		List<Boolean> bools = new ArrayList<Boolean>();
//		bools.add(this.upperLeft.getX() >= r.getUpperLeft().getX() && 
//				this.upperLeft.getX() <= r.getLowerRight().getX());
//		bools.add(this.upperLeft.getY() >= r.getLowerRight().getY() && 
//				this.upperLeft.getY() <= r.getUpperLeft().getY());
//		bools.add(this.lowerRight.getX() >= r.getUpperLeft().getX() && 
//				this.lowerRight.getX() <= r.getLowerRight().getX());
//		bools.add(this.lowerRight.getY() >= r.getLowerRight().getY() && 
//				this.lowerRight.getY() <= r.getUpperLeft().getY());
//		
//		//If the number of points between the other rectangles two points is larger than 2,
//		//then the whole rectangle is within this rectangle and there is no intersection
//		int count = 0;
//		for (boolean bool : bools) {
//			if (bool) count++;
//		}
//		
//		if (count == 0) {
//			return false;
//		} else if (count > 2) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//	
//	public Point getUpperLeft() {
//		return upperLeft;
//	}
//	
//	public Point getLowerRight() {
//		return lowerRight;
//	}
//}
//
//class Point {
//	private int x;
//	private int y;
//	
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	public int getX() {
//		return x;
//	}
//	
//	public int getY() {
//		return y;
//	}
//}