import java.util.LinkedList;

public class HeapChecker2 {
	
	public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		boolean correct = false;
		
		if(hRemoved.isHeap()==false) {
			correct = false;
		}
		else {
			expectedValues(hOrig,hRemoved){}
		}

		return correct;


	  }
	
	boolean expectedSize(IHeap Orig,IBinTree After) {
		if(After.size()==(Orig.size()-1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean expectedValues(IHeap Orig,IBinTree After) {
		LinkedList<Integer> origlist = new LinkedList<Integer>();
		LinkedList<Integer> afterlist = new LinkedList<Integer>();
		
		origlist = Orig.btToList();
		origlist.remove(0);
		afterlist = After.btToList();
		
		if(origlist.equals(afterlist)) {
			
		}
	}

}
