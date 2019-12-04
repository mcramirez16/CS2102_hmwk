import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;

public class Examples {
	
	ReportList ExistingData = new ReportList();
	WeatherMonitor wm1 = new WeatherMonitor(ExistingData);
	LinkedList<Reading> sensor1 = new LinkedList<Reading>();
	LinkedList<Reading> sensor2 = new LinkedList<Reading>();
	LinkedList<Reading> sensor3 = new LinkedList<Reading>();
	
	public Examples(){
		
	}
	
	/**
	 * Tests the basic functionality of the rainfall function
	 */
	@Test
	public void rainfallTest1() {
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		assertEquals(wm1.totalRainfallForMonth(0, 2019), 5.0, 0.01);
	}
	
	/**
	 * Tests if the rainfall function can handle zero values
	 */
	@Test
	public void rainfallEmptyTest() {
		Reading rdg1=new Reading(40.0,0.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,0.0,new Time(6,0));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		assertEquals(wm1.totalRainfallForMonth(0, 2019),0.0,0.01);
		
	}
	
	/**
	 * Tests if the rainfall function correctly distinguishes data between months 
	 */
	@Test
	public void RainfallTestMultipleMonths() {
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		Reading rdg3 = new Reading(30.0,3.0,new Time(3,22));
		Reading rdg4 = new Reading(25.0,4.0,new Time(3,11));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		sensor2.add(rdg3);
		sensor2.add(rdg4);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		wm1.addDailyReport(new GregorianCalendar(2019,2,23), sensor2);
		assertEquals(wm1.totalRainfallForMonth(2, 2019),7.0,0.01);
	}
	
	/**
	 * Tests if the rainfall function can withstand summing data from the same month added in multiple daily reports
	 */
	@Test
	public void RainfallTestAddingAfterOtherReports() {
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		Reading rdg3 = new Reading(30.0,3.0,new Time(3,22));
		Reading rdg4 = new Reading(25.0,4.0,new Time(3,11));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		sensor2.add(rdg3);
		sensor3.add(rdg4);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		wm1.addDailyReport(new GregorianCalendar(2019,2,23), sensor2);
		wm1.addDailyReport(new GregorianCalendar(2019,0,2), sensor3);
		assertEquals(wm1.totalRainfallForMonth(0, 2019),9.0,0.01);
	}
	
	/**
	 * Tests the basic functionality of the temperature function
	 */
	@Test
	public void tempAvgTest1() {
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		assertEquals(wm1.averageTempForMonth(0, 2019), 42.5, 0.01);
	}
	
	/**
	 * Tests if the temperature function can handle zero values
	 */
	@Test
	public void tempEmptyTest() {
		Reading rdg1=new Reading(0.0,1.0,new Time(5,0));
		Reading rdg2=new Reading(0.0,1.0,new Time(6,0));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		assertEquals(wm1.averageTempForMonth(0, 2019),0.0,0.01);
		
	}
	
	/**
	 * Tests if the temperature function can correctly distinguish between months
	 */
	@Test
	public void TempTestMultipleMonths() {
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		Reading rdg3 = new Reading(30.0,3.0,new Time(3,22));
		Reading rdg4 = new Reading(25.0,4.0,new Time(3,11));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		sensor2.add(rdg3);
		sensor2.add(rdg4);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		wm1.addDailyReport(new GregorianCalendar(2019,2,23), sensor2);
		assertEquals(wm1.averageTempForMonth(2, 2019),27.5,0.01);
	}
	
	/**
	 * Tests if the temperature function can average data from the same month added in multiple daily reports
	 */
	@Test
	public void TempTestAddingAfterOtherReports() {
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		Reading rdg3 = new Reading(30.0,3.0,new Time(3,22));
		Reading rdg4 = new Reading(25.0,4.0,new Time(3,11));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
		sensor2.add(rdg3);
		sensor3.add(rdg4);
		wm1.addDailyReport(new GregorianCalendar(2019,0,1), sensor1);
		wm1.addDailyReport(new GregorianCalendar(2019,2,23), sensor2);
		wm1.addDailyReport(new GregorianCalendar(2019,0,2), sensor3);
		assertEquals(wm1.averageTempForMonth(0, 2019),36.66,0.01);
	}
	
	
	

}
