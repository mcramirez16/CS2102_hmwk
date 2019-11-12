import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    
	  Double maxRead = 0.0;
	  LinkedList<MaxHzReport> maxData = new LinkedList<MaxHzReport>();

		for (double datum : data) {
			if (!isDate(datum)) {
				if(datum > maxRead) {
					maxRead = datum;
				} else {
					data.remove(datum);
				}
			} else {
				maxRead = 0.0;
			}
		}
		
		for(int i=0; i < data.size(); i++) {
			if(isDate(data.get(i))) {
				maxData.add(new MaxHzReport(i, i+1));
			}
		}
		
//		System.out.println(maxData);
		for(MaxHzReport aReport : maxData) {
			if(extractMonth(aReport.date) != month) {
				maxData.remove(aReport);
			}
		}
		
		return maxData;
		

	}
}