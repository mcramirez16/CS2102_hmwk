import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {

	HeapChecker HT = new HeapChecker();
	HeapChecker2 HT2 = new HeapChecker2();
	
	IHeap left1 = new TestHeap(3,new MtHeap(),new MtHeap());
	IHeap right1 = new TestHeap(5,new MtHeap(),new MtHeap());
	IHeap heap1 = new TestHeap(2, left1, right1);
	IBinTree leftBT = new DataBT(2,new MtBT(),new MtBT());
	IBinTree rightBT = new DataBT(3,new MtBT(),new MtBT());
	IBinTree treeHeap = new DataBT(1,leftBT,rightBT);
	IBinTree treeNotHeap = new DataBT(5,leftBT,rightBT);
	LinkedList<Integer> l1 = new LinkedList<Integer>();
	LinkedList<Integer> l2 = new LinkedList<Integer>();
	
	@Test
	public void getNodeTest() {
		assertEquals(heap1.getNode(),2);
	}
	
	@Test
	public void getLeftTest() {
		assertEquals(heap1.getLeft(),left1);
	}
	
	@Test
	public void getRightTest() {
		assertEquals(heap1.getRight(),right1);
	}
	
	@Test
	public void isHeapTest() {
		assertTrue(treeHeap.isHeap());
	}
	
	@Test
	public void isNotHeapTest() {
		assertFalse(treeNotHeap.isHeap());
	}
	
	/*
	@Test
	public void expectedValues() {
		IBinTree heap2 = heap1.remMinElt();
		assertTrue(HT2.expectedValues(heap1, heap2));
		
	}
	*/
	
	/*
	@Test
	public void compareList() {
		l1.add(1);
		l1.add(2);
		l1.add(2);
		l1.add(3);
		
		l2.add(1);
		l2.add(2);
		l2.add(2);
		l2.add(3);
		
		boolean equal = l1.equals(l2);
		assertTrue(equal);
	}
	*/
	
	@Test
	public void BtToList() {
		LinkedList<Integer> list = HT.btToList(treeHeap);
		
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		assertEquals(list,l1);
	}
	

}
