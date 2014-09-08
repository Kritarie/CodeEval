package workexperience;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

//https://www.codeeval.com/open_challenges/139/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] data;
		TimePeriod[] periods;
		int workXp, minStart, maxEnd;

		Map<String, Integer> months = new HashMap<String, Integer>();
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
		months.put("May", 5);
		months.put("Jun", 6);
		months.put("Jul", 7);
		months.put("Aug", 8);
		months.put("Sep", 9);
		months.put("Oct", 10);
		months.put("Nov", 11);
		months.put("Dec", 12);
		
		while ((line = in.readLine()) != null) {
			data = line.split(";\\s");
			workXp = 0;
			periods = new TimePeriod[data.length];
			
			
			for (int i = 0; i < data.length; i++) {
				periods[i] = new TimePeriod(
						Integer.parseInt(data[i].substring(4, 8)) * 12 + months.get(data[i].substring(0, 3)),
						Integer.parseInt(data[i].substring(13, 17)) * 12 + months.get(data[i].substring(9, 12)));
			}
			
			minStart = minStart(periods);
			maxEnd = maxEnd(periods);
			
			//If a month is within one of the work periods, add to workxp
			for (int i = minStart; i <= maxEnd; i++) {
				if (isWithinPeriod(i, periods)) workXp++;
			}
			
			System.out.println(workXp / 12);
		}
		
		in.close();
	}
	
	static boolean isWithinPeriod(int x, TimePeriod[] p) {
		for (int i = 0; i < p.length; i++) {
			if (p[i].isWithinRange(x)) return true;
		}
		return false;
	}
	
	static int minStart(TimePeriod[] p) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < p.length; i++) {
			if (p[i].getStartDate() < min) {
				min = p[i].getStartDate();
			}
		}
		return min;
	}
	
	static int maxEnd(TimePeriod[] p) {
		int max = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i].getEndDate() > max) {
				max = p[i].getEndDate();
			}
		}
		return max;
	}
}

class TimePeriod {
	private int startDate, endDate;
	
	public TimePeriod(int startDate, int endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getStartDate() {
		return startDate;
	}

	public int getEndDate() {
		return endDate;
	}
	
	public boolean isWithinRange(int i) {
		return (i >= startDate && i <= endDate);
	}
}