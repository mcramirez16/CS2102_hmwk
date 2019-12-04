
public class Reading {
	 private double degrees;
	 private double rainfall;
	 private Time time = new Time(0,0);
	
	Reading(double degrees,double rainfall,Time time){
		this.degrees = degrees;
		this.rainfall = rainfall;
		this.time = time;
	}
	
	/**
	 * Returns value of stored in temperature for this reading
	 * @return Double temperature value
	 */
	public double getDegrees() {
		return this.degrees;
	}
	
	/**
	 * Returns value stored in rainfall for this reading
	 * @return Double rainfall value
	 */
	public double getRainfall() {
		return this.rainfall;
	}
	
	/**
	 * Returns the time object containing the hour and minute the reading was recorded
	 * @return Time time reading was taken
	 */
	public Time getTime() {
		return this.time;
	}
}
