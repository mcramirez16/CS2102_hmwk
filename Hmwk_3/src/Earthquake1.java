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
		
		boolean rightMonth = false;
		Double maxRead = 0.0;
		Double heldDate = 0.0;
		LinkedList<MaxHzReport> DMFM = new LinkedList<MaxHzReport>();
		
		for(int i=0; i< data.size(); i++) {
			if(isDate(data.get(i))) {
				if(extractMonth(data.get(i)) == month) {
					rightMonth = true;
					heldDate = data.get(i);
				} else {
					rightMonth = false;
				}
			} else {
				if(rightMonth == true) {
					
					int counter = i + 1;

					if(counter == data.size()) {
						maxRead = data.get(i);
					} else {
						if(data.get(counter) > data.get(i) && !isDate(data.get(counter))) {
							maxRead = data.get(counter);
						}
					}
					
					DMFM.add(new MaxHzReport(heldDate, maxRead));
					
				}
			}
			
		}
		return DMFM;
	}

}
