import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;

public class Examples {
	
	WeatherMonitor wm1 = new WeatherMonitor();
	LinkedList<Reading> sensor1 = new LinkedList<Reading>();
	
	Examples(){
		Reading rdg1=new Reading(40.0,3.0,new Time(5,0));
		Reading rdg2=new Reading(45.0,2.0,new Time(6,0));
		sensor1.add(rdg1);
		sensor1.add(rdg2);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
