import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> avgs = new LinkedList<Double>();
	  LinkedList<Double> data = new LinkedList<Double>();
	  LinkedList<Integer> indices = new LinkedList<Integer>();
	  int count = -1;
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
			  sum = 0.0;
			  eps = 0;
		  }
	  }
	  
	  
	  return avgs;
  }
}