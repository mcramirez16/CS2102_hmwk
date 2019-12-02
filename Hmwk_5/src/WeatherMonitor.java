import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor {
	
	LinkedList<DailyWeatherReport> dailyreports = new LinkedList<DailyWeatherReport>();
	
	
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		DailyWeatherReport report = new DailyWeatherReport(date,readings);
		dailyreports.add(report);
		
	}
	
	public double totalRainfallForMonth(int month, int year) {
		double total = 0.0;
		for(int i =0;i<this.dailyreports.size();i++) {
			int rYear = this.dailyreports.get(i).date.get(GregorianCalendar.YEAR);
			if(rYear==year) {
				int rMonth = this.dailyreports.get(i).date.get(GregorianCalendar.MONTH);
				if(rMonth==month) {
					total = calcRainfall(dailyreports.get(i));
				}
			}
		}
		return total;
	}
	
	public double calcRainfall(DailyWeatherReport report) {
		double rainfall = 0.0;
		for(int i =0;i<report.readings.size();i++) {
			rainfall += report.readings.get(i).rainfall;
		}
		
		return rainfall;
	}
	
	public double averageTempForMonth(int month, int year) {
		double avgTempThisMonth = 0.0;
		double tempSum = 0.0;
		int reportCount = 0;
		for(int i =0;i<this.dailyreports.size();i++) {
			int rYear = this.dailyreports.get(i).date.get(GregorianCalendar.YEAR);
			if(rYear==year) {
				int rMonth = this.dailyreports.get(i).date.get(GregorianCalendar.MONTH);
				if(rMonth==month) {
					tempSum = calcTempSum(dailyreports.get(i));
					reportCount = reportCount + 1;
				}
			}
		}
		avgTempThisMonth = tempSum / reportCount;
		return avgTempThisMonth;
	}
	
	public double calcTempSum(DailyWeatherReport report) {

		double totalTemp = 0.0;
		for(int i=0; i<report.readings.size(); i++) {
			totalTemp += report.readings.get(i).degrees;
		}
		
		return totalTemp;
	}

}
