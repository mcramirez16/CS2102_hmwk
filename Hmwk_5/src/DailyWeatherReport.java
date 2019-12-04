import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport implements IReport {
	
	private GregorianCalendar date = new GregorianCalendar(2019,1,1);
	private LinkedList<Double> temps = new LinkedList<Double>();
	private LinkedList<Double> rainfall = new LinkedList<Double>();
	
	DailyWeatherReport(GregorianCalendar date, LinkedList<Double> temps, LinkedList<Double> rainfall){
		this.date.set(Calendar.YEAR, date.get(GregorianCalendar.YEAR));
		this.date.set(Calendar.MONTH, date.get(GregorianCalendar.MONTH));
		this.date.set(Calendar.DAY_OF_MONTH, date.get(GregorianCalendar.DAY_OF_MONTH));
		this.temps.addAll(temps);
		this.rainfall.addAll(rainfall);
	}

}
