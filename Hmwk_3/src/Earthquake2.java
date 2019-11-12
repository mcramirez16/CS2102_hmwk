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

		Double maxRead = 0.0;
		LinkedList<MaxHzReport> maxData = new LinkedList<MaxHzReport>();
		LinkedList<MaxHzReport> unwantedMaxData = new LinkedList<MaxHzReport>();
		LinkedList<Double> testData = new LinkedList<Double>();

		for (double datum : data) {
			if (!isDate(datum)) {
				if (datum > maxRead) {
					maxRead = datum;
				} else {
					testData.add(datum);
				}
			} else {
				maxRead = 0.0;
			}
		}
		
		data.removeAll(testData);

		for (int i = 0; i < data.size()-1; i++) {
			if (isDate(data.get(i))) {
				maxData.add(new MaxHzReport(i, i + 1));
			}
		}

//		System.out.println(maxData);
		for (MaxHzReport aReport : maxData) {
			if (extractMonth(aReport.date) != month) {
				unwantedMaxData.add(aReport);
			}
		}
		
		maxData.removeAll(unwantedMaxData);

		return maxData;

	}

}