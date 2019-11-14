import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}
  
  /**
   * Creates a list of average runtime of each show
   * @param List of shows
   * @return List of doubles of average runtime per show
   */
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> avgs = new LinkedList<Double>();
	  LinkedList<Double> data = new LinkedList<Double>();
	  LinkedList<Integer> indices = new LinkedList<Integer>();
	  
	  int count = -1;//since the index starts at 0, count starts at -1
	  for(Show s: shows) {
		  for(Episode e: s.episodes) {
			  data.add(e.runTime);
			  count++;
		  }
		  indices.add(count);
	  }
	  Double sum = 0.0;
	  int eps = 0;
	  for(int i = 0; i< data.size();i++) {
		  sum += data.get(i);
		  eps += 1;
		  if(indices.contains(i)) {
			  avgs.add(sum/eps);
			  sum = 0.0;//reset sum to zero for next show average
			  eps = 0;//reset number of episodes to zero for next show average
		  }
	  }
	  
	  
	  return avgs;
  }
}