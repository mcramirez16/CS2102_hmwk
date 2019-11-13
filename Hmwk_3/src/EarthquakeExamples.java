import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>(); 
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<Double> datesWithNegative = new LinkedList<Double>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
  LinkedList<Double> goodDatesNotConsecutive = new LinkedList<Double>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    datesWithNegative.add(20151013.0);
    datesWithNegative.add(-10.0);
    datesWithNegative.add(5.0);
    datesWithNegative.add(20151020.0);
    datesWithNegative.add(40.0);
    datesWithNegative.add(-50.0);
    datesWithNegative.add(45.0);
    datesWithNegative.add(20151101.0);
    datesWithNegative.add(6.0);
    OctReports.add(new MaxHzReport(20151013.0, 5.0));
    OctReports.add(new MaxHzReport(20151020.0, 45.0));
    goodDatesNotConsecutive.add(20151013.0);
    goodDatesNotConsecutive.add(-10.0);
    goodDatesNotConsecutive.add(5.0);
    goodDatesNotConsecutive.add(20151101.0);
    goodDatesNotConsecutive.add(6.0);
    goodDatesNotConsecutive.add(20151020.0);
    goodDatesNotConsecutive.add(40.0);
    goodDatesNotConsecutive.add(-50.0);
    goodDatesNotConsecutive.add(45.0);
  }

  @Test
  public void Earthquake1Test1() { 
	  assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
  }
  
  @Test 
  public void Earthquake1Test2() {
	  assertEquals(OctReports, E1.dailyMaxForMonth(datesWithNegative, 10));
  }
  
  @Test 
  public void Earthquake1Test3() {
	  assertEquals(OctReports, E1.dailyMaxForMonth(goodDatesNotConsecutive, 10));
  }
  
  @Test
  public void Earthquake2Test1() { 
	    assertEquals(NovReports, E2.dailyMaxForMonth(threeDates, 11));
	  }
  
  @Test 
  public void Earthquake2Test2() {
	  assertEquals(OctReports, E2.dailyMaxForMonth(datesWithNegative, 10));
  }
  
  @Test 
  public void Earthquake2Test3() {
	  assertEquals(OctReports, E2.dailyMaxForMonth(goodDatesNotConsecutive, 10));
  }
  
  /**
   * Subtasks for Earthquake1 (Solution 1):
   * 
   * CHECKING MONTH OF INTEREST
   * STORE DATE OF INTEREST
   * SKIPPING IRRELAVENT DATE AND ITS READINGS
   * PICK OUT MAX SEISMIC READING OF THE STORED DATE
   * GENARATE MAX HERZ REPORT
   * MAKE A LIST OF MAX HERZ REPORT
   * 
   * 
   * Subtasks for Earthquake2 (Solution 2):
   * 
   * IDENTIFY MAX READING FOR EACH DATE
   * ELIMINATE NON MAX READINGS FOR EACH DATE
   * GENERATE MAX HERZ REPORT FOR EACH DATE FROM CLEANED LIST
   * MAKE A LIST OF THESE MAX HERZ REPORT
   * CHECK MONTH OF INTEREST
   * ELIMINATE OTHER MONTHS' MAX HERZ REPORTS
   */

}
