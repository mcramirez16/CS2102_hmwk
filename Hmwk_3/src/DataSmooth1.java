import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}
  /**
   * Creates a list of average runtime of each show
   * @param List of shows
   * @return List of doubles of average runtime per show
   */
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> avgs = new LinkedList<Double>();
	 
	  for(Show s: shows) {
		  Double sum = 0.0;
		  for (Episode e: s.episodes) {
			 sum += e.runTime; 
		  }
		  avgs.add(sum/s.episodes.size());
	  }
	  
	  return avgs;
  }
}