import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {
	
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
	
	/**
	 * Returns the date in GregorianCalendar format
	 * @return GregorianCalendar date
	 */
	public GregorianCalendar getDate() {
		return this.date;
	}
	
	/**
	 * Returns size of temperature list, both lists should be the same size
	 * @return Integer size of rainfall & temperature list
	 */
	public int getSize() {
		return this.temps.size();
	}
	
	/**
	 * Calculates total rainfall in the report
	 * @return Double sum of rainfall from the report
	 */
	public double getTotalRainfall () {
		double total=0.0;
		for(int i =0;i<rainfall.size();i++) {
			total+=rainfall.get(i);
		}
		return total;
	}
	
	/**
	 * Calculates total temperature readings for averaging
	 * @return Double sum of temperatures from the report
	 */
	public double getTotalTemp() {
		double total=0.0;
		for(int i =0;i<temps.size();i++) {
			total+=temps.get(i);
		}
		return total;
	}

}
