import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;

public class Examples {
	
	WeatherMonitor wm1 = new WeatherMonitor();
	LinkedList<Reading> sensor1 = new LinkedList<Reading>();

	@Test
	public void test() {
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		wm1.addDailyReport(new GregorianCalendar(2019,12,1), sensor1);
		assertEquals(wm1.totalRainfallForMonth(12, 2019), 5.0, 0.01);
	}

}
