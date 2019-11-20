import java.util.LinkedList;

public class HeapChecker {

	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		return false;

		   

	  }
	
	public boolean isHeap(IBinTree aBT) {// determines if a binary tree is a heap
		boolean updateBool = false;
		
		if(aBT.getNode() == 0) {
			updateBool = true;//returns false when the BT is empty;
		}
		else {
			if(aBT.getNode() < aBT.getLeft().getNode()) {
				updateBool = true;
				if(isHeap(aBT.getLeft())) {
					if(aBT.getNode() < aBT.getRight().getNode()) {
						updateBool = true;
						if(isHeap(aBT.getRight())) {
							updateBool = true;
						} else {
							updateBool = false;
						}
					}
				}
				
			}
		}
		return updateBool;
	}

	public LinkedList<Integer> heapToList(IHeap aHP) {
		return null;// converts a heap to a linked list
		
	}
	
	public LinkedList<Integer> btToList(IBinTree aBT){
		return null;// converts a binary tree to a list
		
	}
	
	public boolean containSameElts(LinkedList<Integer> lOrig, LinkedList<Integer> lAdded) {// checks if the elements
		//are the same and have the same number of occurrences except the added term
		int origCounter = 0;
		int addedCounter = 0;
		return false;
	}
}




