import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	ShowManager2 sm2= new ShowManager2();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	ShowSummary specialReport = new ShowSummary();
	
	public ShowExamples()
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1, false);
		shows.add(s1);
		report1.primetime.add(s1);
		specialReport.primetime.add(s1);
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2, false);
		shows.add(s2);
		report1.primetime.add(s2);
		specialReport.primetime.add(s2);
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3, false);
		shows.add(s3);
		report1.daytime.add(s3);
		specialReport.daytime.add(s3);
		
		LinkedList<Episode> special1 = new LinkedList<Episode>();
		special1.add(new Episode("Muppets Christmas Special",3));
		Show sp1 = new Show("Muppets Christmas Special",2200,special1,true);
		specialReport.latenight.add(sp1);
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4, false);
		shows.add(s4);
		report1.daytime.add(s4);
	}
	
	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	
	@Test
	public void sm2_instructorTest() {
		ShowSummary report3 = sm2.organizeShows(shows);
		assertEquals(report1,report3);
	}
	
	/*
	 * Subtasks for Problem 1 (Solution 1):
	 * Go through shows in a loop
	 * Determine if the show falls in daytime,primetime or latenight
	 * Determine if the show is a special
	 * Add to list if these requirements are met
	 * Put shows in a summary in the original order using the Strings obtained earlier
	 * */
	
	/*
	 * Subtasks for Problem 1 (Solution 2):
	 * Go through each and add each show in loop
	 * If the show is not in daytime,primetime, or latenight remove it from the list
	 * 
	 * */

}
