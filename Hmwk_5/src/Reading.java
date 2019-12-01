
public class Reading {
	double degrees;
	double rainfall;
	Time time = new Time(0,0);
	
	Reading(double degrees,double rainfall,Time time){
		this.degrees = degrees;
		this.rainfall = rainfall;
		this.time = time;
	}
}
