import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {
	
	GregorianCalendar date = new GregorianCalendar(2019,1,1);
	LinkedList<Double> temps = new LinkedList<Double>();
	LinkedList<Double> rainfall = new LinkedList<Double>();
	
	DailyWeatherReport(GregorianCalendar date, LinkedList<Double> temps, LinkedList<Double> rainfall){
		this.date.set(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH), date.get(GregorianCalendar.DAY_OF_MONTH));
		this.temps.addAll(temps);
		this.rainfall.addAll(rainfall);
	}

}
