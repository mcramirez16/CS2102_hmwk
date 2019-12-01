import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {
	
	GregorianCalendar date = new GregorianCalendar(2016,11,17);
	LinkedList<Reading> readings = new LinkedList<Reading> ();
	
	DailyWeatherReport(GregorianCalendar date, LinkedList<Reading> readings){
		this.date= date;
		this.readings = readings;
	}

}
