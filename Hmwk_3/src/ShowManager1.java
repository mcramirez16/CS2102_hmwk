import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}

	public ShowSummary organizeShows(LinkedList<Show> shows){
		ShowSummary newReport = new ShowSummary();
		for(int i = 0; i<shows.size();i++) {
			switch(timeShown(shows.get(i))) {
			case 1 :
				if(shows.get(i).isSpecial==false) {
				newReport.daytime.add(shows.get(i));
				}
				break;
			case 2 :
				if(shows.get(i).isSpecial==false) {
				newReport.primetime.add(shows.get(i));
				}
				break;
			case 3 : 
				if(shows.get(i).isSpecial==false) {
				newReport.latenight.add(shows.get(i));
				}
				break;
			}
		}
		
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

}