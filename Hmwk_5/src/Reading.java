
public class Reading {
	 private double degrees;
	 private double rainfall;
	 private Time time = new Time(0,0);
	
	Reading(double degrees,double rainfall,Time time){
		this.degrees = degrees;
		this.rainfall = rainfall;
		this.time = time;
	}
	
	public double getDegrees() {
		return this.degrees;
	}
	
	public double getRainfall() {
		return this.rainfall;
	}
	
	public Time getTime() {
		return this.time;
	}
}
