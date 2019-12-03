import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor {
	
	LinkedList<DailyWeatherReport> dailyreports = new LinkedList<DailyWeatherReport>();
	
	
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		LinkedList<Double> temps = new LinkedList<Double>();
		LinkedList<Double> rainfall = new LinkedList<Double>();
		for(int i=0;i<readings.size();i++) {
			temps.add(readings.get(i).degrees);
			rainfall.add(readings.get(i).rainfall);
		}
		DailyWeatherReport report = new DailyWeatherReport(date,temps,rainfall);
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
		for(int i =0;i<report.rainfall.size();i++) {
			rainfall+=report.rainfall.get(i);
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
					reportCount = dailyreports.get(i).temps.size();
				}
			}
		}
		avgTempThisMonth = tempSum / reportCount;
		return avgTempThisMonth;
	}
	
	public double calcTempSum(DailyWeatherReport report) {

		double totalTemp = 0.0;
		for(int i=0; i<report.temps.size(); i++) {
			totalTemp += report.temps.get(i);
		}
		
		return totalTemp;
	}

}
