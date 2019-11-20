import java.util.LinkedList;

public class HeapChecker2 {
	
	public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		boolean correct = false;
		
		if(hRemoved.isHeap()==false) {
			correct = false;
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
	
	boolean expectedValues(IHeap Orig, IBinTree After) {
		boolean update = false;
		
			if(Orig.hasElt(After.getNode())==false && After.getLeft()!=null && After.getRight()!= null){
				update = false;
			}
			else if(expectedValues(Orig,After.getLeft())){
				update = true;
				if(expectedValues(Orig,After.getRight())) {
					update = true;
				} else {
					update = false;
				}
			}
			
			return update;
	}

}
