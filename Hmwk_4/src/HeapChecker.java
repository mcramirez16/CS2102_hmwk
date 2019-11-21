import java.util.LinkedList;

public class HeapChecker {
	
	LinkedList<Integer> abtEltList = new LinkedList<Integer>();

	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		if(hAdded.isHeap() != true) {
			return false;
		} else {
			
		}
		

	  }
	
	
	public LinkedList<Integer> btToList(IBinTree aBT){// converts a binary tree to a list
		
		if(aBT.size() != 0) {
			
			abtEltList.add(aBT.getNode());
			btToList(aBT.getLeft());
			btToList(aBT.getRight());
		}
		
		return abtEltList;
	}
	
	public boolean containSameEltsForAddEltTester(LinkedList<Integer> lOrig, LinkedList<Integer> lAdded) {// checks if the elements
		//are the same and have the same number of occurrences except the added term
		

		
		return false;
	}
	
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
		
		//origlist = Orig.btToList();
		origlist.remove(0);
		//afterlist = After.btToList();
		
		//if(origlist.equals(afterlist)) {
			
		//}
		return false;
	}
}




