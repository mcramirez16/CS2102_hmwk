import java.util.LinkedList;

public class WeatherMonitor {
	
	LinkedList<DailyWeatherReport> dailyreports = new LinkedList<DailyWeatherReport>();
	
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
		for(int i =0;i<report.rainfall.size();i++) {
			rainfall+=report.rainfall.get(i);
		}
		return rainfall;
	}

}
