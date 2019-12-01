import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {
	
	GregorianCalendar date = new GregorianCalendar();
	LinkedList<Reading> readings = new LinkedList<Reading> ();
	
	DailyWeatherReport(GregorianCalendar date, LinkedList<Reading> readings){
		this.date.set(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH), date.get(GregorianCalendar.DAY_OF_MONTH));
		this.readings = readings;
	}

}
