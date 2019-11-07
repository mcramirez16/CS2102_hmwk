import java.util.LinkedList;

class Earthquake1 {
	Earthquake1() {
	}

	// checks whether a datum is a date
	boolean isDate(double anum) {
		return (int) anum > 10000000;
	}

	// extracts the month from an 8-digit date
	int extractMonth(double dateNum) {
		return ((int) dateNum % 10000) / 100;
	}

	public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
		
		boolean rightMonth;
		Double maxRead;
		LinkedList<MaxHzReport> dailyMaxForMonth = new LinkedList<MaxHzReport>();
		
		for(int i=0; i < data.size(); i++) {	
			if(isDate(data.get(i))) {
				if(extractMonth(data.get(i)) == month) {
					rightMonth = true;
					else {
						rightMonth = false;
				}
				
			}
			else {
				if(rightMonth == true) {
					if(data.get(i + 1) > data.get(i + 2)) {
						dailyMaxForMonth.add(new MaxHzReport(data.get(i), data.get(i)));
					}
				}
			}
		}
	}
}
