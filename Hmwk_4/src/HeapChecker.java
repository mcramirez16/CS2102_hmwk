import java.util.LinkedList;
import java.util.Collections;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class HeapChecker {
	
	LinkedList<Integer> abtEltList = new LinkedList<Integer>();
	
	/**
	 * Checks if an element was added to a heap correctly
	 * @param hOrig Original Heap
	 * @param elt Element being added
	 * @param hAdded Tree addElt() was used on
	 * @return boolean True if the element was added correctly
	 */
	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		if (hAdded.isHeap() != true) {
			return false;
		} else {
			if (expectedSizeForAdd(hOrig, hAdded) != true) {
				return false;
			} else {
				LinkedList<Integer> origList = btToList(hOrig);
				LinkedList<Integer> addedList = btToList(hAdded);
				origList.add(elt);
				origList = sortList(origList);
				addedList = sortList(addedList);

				if (origList.equals(addedList) != true) {
					return false;
				} else {
					return true;
				}
			}
		}

	}
	
	/**
	 * Checks if the minimum/first node was removed correctly
	 * @param hOrig Original Heap
	 * @param hRemoved Tree remMinElt() was used on
	 * @return boolean True if the node was removed correctly
	 */
	public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		
		if (hRemoved.isHeap() != true) {
			return false;
		} else {
			if (expectedSizeForRem(hOrig, hRemoved) != true) {
				return false;
			} else {
				LinkedList<Integer> origList = btToList(hOrig);
				LinkedList<Integer> addedList = btToList(hRemoved);
				origList.remove(0);
				origList = sortList(origList);
				addedList = sortList(addedList);

				if (origList.equals(addedList) != true) {
					return false;
				} else {
					return true;
				}
			}
		}
	
	  }
	
	/**
	 * Turns a Tree into a List of Integers
	 * @param aBT Binary Tree
	 * @return LinkedList of integers
	 */
	public LinkedList<Integer> btToList(IBinTree aBT){// converts a binary tree to a list
		
		if(aBT.size() != 0) {
			
			abtEltList.add(aBT.getNode());
			btToList(aBT.getLeft());
			btToList(aBT.getRight());
		}
		
		return abtEltList;
	}
	
	/**
	 * Sorts a list in ascending order
	 * @param aList LinkedList of integers
	 * @return LinkedList of integers that has been sorted
	 */
	public LinkedList<Integer> sortList(LinkedList<Integer> aList){
		Collections.sort(aList);
		return aList;
	}
	
	/**
	 * Checks if a Tree is the expected size after the minimum node is removed
	 * @param Orig Original Heap
	 * @param After Tree remMinElt() has been used on
	 * @return boolean True if Tree is the expected size
	 */
	boolean expectedSizeForRem(IHeap Orig,IBinTree After) {
		if(After.size()==(Orig.size()-1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if a Tree is the expected size after an element has been added
	 * @param Orig Original Heap
	 * @param After Tree addElt() has been used on
	 * @return boolean True if Tree is the expected size
	 */
	boolean expectedSizeForAdd(IHeap Orig,IBinTree After) {
		if(After.size()==(Orig.size()+1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}




