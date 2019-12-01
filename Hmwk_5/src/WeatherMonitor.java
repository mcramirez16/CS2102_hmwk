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
			if(this.dailyreports.get(i).date.YEAR==year) {
				if(this.dailyreports.get(i).date.MONTH==month) {
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

}
