import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}

	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary newReport = new ShowSummary();
		for(int i=0;i<shows.size();i++) {
			switch(timeShown(shows.get(i))) {
			case 1:
				newReport.daytime.add(shows.get(i));
				break;
			case 2:
				newReport.primetime.add(shows.get(i));
				break;
			case 3:
				newReport.latenight.add(shows.get(i));
				break;
			}
		}
		
		removeSpecials(newReport);
		
		return newReport;
	}
	
	public int timeShown(Show show) {
		int slot = 0;
		if(show.broadcastTime > 600 && show.broadcastTime < 1700 ) {
			slot = 1;
		}
		else if(show.broadcastTime >= 1700 && show.broadcastTime < 2200) {
			slot = 2;
		}
		else if(show.broadcastTime >=2200 && show.broadcastTime < 100){
			slot = 3;
		}
		
		return slot;
	}
	
	public void removeSpecials(ShowSummary report) {
		for(int i=0;i<report.daytime.size();i++) {
			if(report.daytime.get(i).isSpecial==true) {
				report.daytime.remove(i);
			}
		}
		
		for(int i=0;i<report.primetime.size();i++) {
			if(report.primetime.get(i).isSpecial==true) {
				report.primetime.remove(i);
			}
		}
		
		for(int i=0;i<report.latenight.size();i++) {
			if(report.latenight.get(i).isSpecial==true) {
				report.latenight.remove(i);
			}
		}
	}
}
