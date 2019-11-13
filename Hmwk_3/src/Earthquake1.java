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

	/**
	 * From a list of daily seismic readings,
	 * produces a list of reports indicating the 
	 * highest frequency reading for each day in the interested month.
	 * @param data
	 * @param month
	 * @return a list of reports indicating the 
	 * highest seismic reading for each day in the month.
	 */
	public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

		boolean rightMonth = false;
		Double heldDate = 0.0;
		LinkedList<MaxHzReport> DMFM = new LinkedList<MaxHzReport>();

		for (double datum : data) {
			if (isDate(datum)) {
				if (extractMonth(datum) == month) {
					rightMonth = true;
					heldDate = datum;
				} else {
					rightMonth = false;
				}
			} else {
				if (rightMonth == true) {

					DMFM.add(new MaxHzReport(heldDate, pickMaxReading(data)));

				}
			}

		}
		return DMFM;
	}


	/**
	 * Picks out the highest reading from a list of only seismic readings
	 * @param data
	 * @return the highest seismic reading
	 */
	public double pickMaxReading(LinkedList<Double> data) {
		Double maxRead = 0.0;

		for (int i = 0; i < data.size(); i++) {
			int counter = i + 1;

			if (counter == data.size()) {
				maxRead = data.get(i);
			} else {
				if (data.get(counter) > data.get(i) && !isDate(data.get(counter))) {
					maxRead = data.get(counter);
				}
			}
		}
		return maxRead;
	}

}
