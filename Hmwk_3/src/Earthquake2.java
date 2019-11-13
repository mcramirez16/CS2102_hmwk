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