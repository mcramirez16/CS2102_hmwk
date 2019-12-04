import java.util.LinkedList;

public class ReportList implements IList{
	
	private LinkedList<DailyWeatherReport> reports = new LinkedList<DailyWeatherReport>();
	
	ReportList(LinkedList<DailyWeatherReport> reports){
		this.reports = reports;
	}
	
	public int getSize() {
		return this.reports.size();
	}
	
	public DailyWeatherReport getReport(int index) {
		return this.reports.get(index);
	}

}
