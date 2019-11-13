import java.util.LinkedList;

class Earthquake2 {
	Earthquake2() {
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

		LinkedList<MaxHzReport> maxData = new LinkedList<MaxHzReport>();
		LinkedList<MaxHzReport> unwantedMaxData = new LinkedList<MaxHzReport>();

		maxData = makeReportList(removeNonMaxReading(data));

		for (MaxHzReport aReport : maxData) {
			if (extractMonth(aReport.date) != month) {
				unwantedMaxData.add(aReport);
			}
		}

		maxData.removeAll(unwantedMaxData);

		return maxData;

	}

	/**
	 * Removes all seismic readings of each day except the highest reading
	 * @param data
	 * @return a list of daily maximum seismic readings
	 */
	public LinkedList<Double> removeNonMaxReading(LinkedList<Double> data) {
		Double maxRead = 0.0;

		LinkedList<Double> trashData = new LinkedList<Double>();

		for (double datum : data) {
			if (!isDate(datum)) {
				if (datum > maxRead) {
					maxRead = datum;
				} else {
					trashData.add(datum);
				}
			} else {
				maxRead = 0.0;
			}
		}

		data.removeAll(trashData);

		return data;
	}
	

	/**
	 * Generates a list of maximum seismic reading reports from a list of daily max readings
	 * @param data
	 * @return a list of maximum seismic reading reports
	 */
	public LinkedList<MaxHzReport> makeReportList(LinkedList<Double> data) {

		LinkedList<MaxHzReport> maxData = new LinkedList<MaxHzReport>();

		for (int i = 0; i < data.size() - 1; i++) {
			if (isDate(data.get(i))) {
				maxData.add(new MaxHzReport(data.get(i), data.get(i + 1)));
			}
		}

		return maxData;
	}

}