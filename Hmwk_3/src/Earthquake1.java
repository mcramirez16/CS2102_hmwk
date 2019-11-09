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
		int counter;
		LinkedList<MaxHzReport> DMFM = new LinkedList<MaxHzReport>();
		
		for(int i=0; i< data.size(); i++) {
			if(isDate(data.get(i))) {
				if(extractMonth(data.get(i)) == month) {
					rightMonth = true;
				} else {
					rightMonth = false;
				}
			} else {
				if(rightMonth == true) {
					counter = i+1;
					maxRead = data.get(counter);
					while(counter < data.size() && !isDate(data.get(counter))) {
						if(maxRead < data.get(counter)) {
							maxRead = data.get(counter);
						}
						counter++;
					}
					
					DMFM.add(new MaxHzReport(data.get(i), maxRead));
					
				}
			}
			
		}
		return DMFM;
	}

}
