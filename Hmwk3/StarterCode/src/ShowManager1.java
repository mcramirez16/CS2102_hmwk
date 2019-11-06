import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}

	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<String> order = new LinkedList<String>();
		for(int i = 0; i<shows.size();i++) {
			order.add(shows.get(i).title);
		}
		
		LinkedList<ShowSummary> nonSpecials = new LinkedList<ShowSummary>();
		
		for(int i = 0;i<shows.size();i++) {
			
		}
		
	}
	
}
