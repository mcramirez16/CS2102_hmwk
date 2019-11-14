import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}
	/**
	 * Creates a ShowSummary containing only non-specials within a certain broadcast time
	 * @param List of shows
	 * @return ShowSummary
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary newReport = new ShowSummary();
		LinkedList<Show> trashData = new LinkedList<Show>();
		
		for(Show s: shows) {
			if(s.broadcastTime > 100 && s.broadcastTime < 600) {
			trashData.add(s);
			}
			else if(s.isSpecial==true) {
				trashData.add(s);
			}
		}
		
		shows.removeAll(trashData);
		
		for(int i = 0; i<shows.size();i++) {
			switch(timeShown(shows.get(i))) {
			case 1 :
				newReport.daytime.add(shows.get(i));
				break;
			case 2 :
				newReport.primetime.add(shows.get(i));
				break;
			case 3 : 
				newReport.latenight.add(shows.get(i));
				break;
			}
		}
		
		
		return newReport;
	}
	
	/**
	 * Determines what slot a show airs on based on broadcast time
	 * @param show
	 * @return int slot
	 */
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
