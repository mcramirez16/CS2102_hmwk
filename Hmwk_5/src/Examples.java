import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;

public class Examples {
	

	//LinkedList<DailyWeatherReport> ExistingData = new LinkedList<DailyWeatherReport>();
	ReportList ExistingData = new ReportList();
	WeatherMonitor wm1 = new WeatherMonitor(ExistingData);
	LinkedList<Reading> sensor1 = new LinkedList<Reading>();
	
	public Examples(){
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
	}

	@Test
	public void rainfallTest1() {
		assertEquals(wm1.totalRainfallForMonth(0, 2019), 5.0, 0.01);
	}
	
	@Test
	public void tempAvgTest1() {
		assertEquals(wm1.averageTempForMonth(0, 2019), 42.5, 0.01);
	}

}
