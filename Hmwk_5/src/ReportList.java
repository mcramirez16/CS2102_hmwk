import java.util.LinkedList;

public class ReportList implements IList{
	
	private LinkedList<DailyWeatherReport> reports = new LinkedList<DailyWeatherReport>();
	
	/**
	 * Returns size of list of daily reports
	 * @return int size of report list
	 */
	public int getSize() {
		return this.reports.size();
	}
	
	/**
	 * Returns a daily report specified by a given index
	 * @return DailyWeatherReport a particular report by index
	 */
	public DailyWeatherReport getReport(int index) {
		return this.reports.get(index);
	}
	
	/**
	 * Adds a report to the list of reports given the new report
	 */
	public void addReport(DailyWeatherReport newReport) {
		reports.add(newReport);
	}

}
