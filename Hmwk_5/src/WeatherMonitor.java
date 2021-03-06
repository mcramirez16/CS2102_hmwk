import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor {
	
	IList dailyreports = new ReportList();
	
	WeatherMonitor(IList dailyreports){
		this.dailyreports = dailyreports;
	}
	
	/**
	 * Adds a daily report to the list of reports
	 * @param Gregorian Calendar date
	 * @param LinkedList of Reading readings
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		LinkedList<Double> temps = new LinkedList<Double>();
		LinkedList<Double> rainfall = new LinkedList<Double>();
		for(int i=0;i<readings.size();i++) {
			temps.add(readings.get(i).getDegrees());
			rainfall.add(readings.get(i).getRainfall());
		}
		DailyWeatherReport report = new DailyWeatherReport(date,temps,rainfall);
		dailyreports.addReport(report);
		
	}
	
	/**
	 * Calculates the total rainfall in a given month
	 * @param int month
	 * @param int year
	 * @return Double sum of rainfall in that month
	 */
	public double totalRainfallForMonth(int month, int year) {
		double total = 0.0;
		for(int i =0;i<this.dailyreports.getSize();i++) {
			int rYear = this.dailyreports.getReport(i).getDate().get(GregorianCalendar.YEAR);
			if(rYear==year) {
				int rMonth = this.dailyreports.getReport(i).getDate().get(GregorianCalendar.MONTH);
				if(rMonth==month) {
					total += dailyreports.getReport(i).getTotalRainfall();
				}
			}
		}
		return total;
	}
	
	/**
	 * Calculates average temperature for a given month
	 * @param int month
	 * @param int year
	 * @return Double average temperature in that month
	 */
	public double averageTempForMonth(int month, int year) {
		double avgTempThisMonth = 0.0;
		double tempSum = 0.0;
		int reportCount = 0;
		for(int i =0;i<this.dailyreports.getSize();i++) {
			int rYear = this.dailyreports.getReport(i).getDate().get(GregorianCalendar.YEAR);
			if(rYear==year) {
				int rMonth = this.dailyreports.getReport(i).getDate().get(GregorianCalendar.MONTH);
				if(rMonth==month) {
					tempSum += dailyreports.getReport(i).getTotalTemp();
					reportCount += dailyreports.getReport(i).getSize();
				}
			}
		}
		avgTempThisMonth = tempSum / reportCount;
		return avgTempThisMonth;
	}
	

}
