import java.util.LinkedList;
import java.util.Collections;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class HeapChecker {
	
	LinkedList<Integer> abtEltList = new LinkedList<Integer>();

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
	
	
	public LinkedList<Integer> btToList(IBinTree aBT){// converts a binary tree to a list
		
		if(aBT.size() != 0) {
			
			abtEltList.add(aBT.getNode());
			btToList(aBT.getLeft());
			btToList(aBT.getRight());
		}
		
		return abtEltList;
	}
	
	public LinkedList<Integer> sortList(LinkedList<Integer> aList){
		Collections.sort(aList);
		return aList;
	}
	
	
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
	
	boolean expectedSizeForRem(IHeap Orig,IBinTree After) {
		if(After.size()==(Orig.size()-1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean expectedSizeForAdd(IHeap Orig,IBinTree After) {
		if(After.size()==(Orig.size()+1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}




