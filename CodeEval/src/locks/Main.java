package locks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/153/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int n, m;
		Door[] doors;
		while (in.hasNext()) {
			n = in.nextInt();
			m = in.nextInt();
			
			doors = new Door[n];
			
			//Initialize doors
			for (int i = 0; i < n; i++) {
				doors[i] = new Door();
			}
			
			for (int i = 0; i < m - 1; i++) {
				runBeat(doors);
			}
			
			//Last iteration
			doors[n-1].changeState();
			
			System.out.println(numUnlocked(doors));
		}
		
		in.close();
	}

	private static int numUnlocked(Door[] doors) {
		int result = 0;
		for (Door d : doors) {
			result += d.isLocked() ? 0 : 1;
		}
		return result;
	}

	private static void runBeat(Door[] doors) {
		//Lock every second door
		for (int i = 1; i < doors.length; i += 2) {
			doors[i].lock();
		}
		
		//Change every third door
		for (int i = 2; i < doors.length; i += 3) {
			doors[i].changeState();
		}
	}
}

class Door {
	private boolean locked;
	
	public Door() {
		locked = false;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void changeState() {
		locked = locked ? false : true;
	}
	
	public void lock() {
		locked = true;
	}
}