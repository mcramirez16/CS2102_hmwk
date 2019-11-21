import java.util.LinkedList;

public class HeapChecker {
	
	LinkedList<Integer> abtEltList = new LinkedList<Integer>();

	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		return false;

		   

	  }
	
	
	public LinkedList<Integer> btToList(IBinTree aBT){// converts a binary tree to a list
		
		if(aBT.size() != 0) {
			
			abtEltList.add(aBT.getNode());
			btToList(aBT.getLeft());
			btToList(aBT.getRight());
		}
		
		return abtEltList;
	}
	
	public boolean containSameElts(LinkedList<Integer> lOrig, LinkedList<Integer> lAdded) {// checks if the elements
		//are the same and have the same number of occurrences except the added term
		int origCounter = 0;
		int addedCounter = 0;
		return false;
	}
}




