import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {

	HeapChecker HT = new HeapChecker();
	
	DataHeap left1 = new DataHeap(3,new MtHeap(),new MtHeap());
	DataHeap right1 = new DataHeap(5,new MtHeap(),new MtHeap());
	IHeap heap1 = new DataHeap(2, left1, right1);
	IBinTree leftBT = new DataBT(2,new MtBT(),new MtBT());
	IBinTree rightBT = new DataBT(3,new MtBT(),new MtBT());
	IBinTree treeHeap = new DataBT(1,leftBT,rightBT);
	IBinTree treeNotHeap = new DataBT(5,leftBT,rightBT);
	TestHeap badHeap1 = new TestHeap(2,left1,right1);
	TestHeap2 badHeap2 = new TestHeap2(2,left1,right1);
	TestHeap3 badHeap3 = new TestHeap3(2,left1,right1);
	TestHeap4 badHeap4 = new TestHeap4(2,left1,right1);
	TestHeap5 badHeap5 = new TestHeap5(2,left1,right1);
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
	
	@Test
	public void expectedSizeAddElt() {
		IBinTree heap2 = heap1.addElt(6);
		HT.expectedSizeForAdd(heap1, heap2);
	}
	
	@Test
	public void expectedSizeRemMinElt() {
		IBinTree heap2 = heap1.remMinElt();
		HT.expectedSizeForRem(heap1, heap2);
	}
	
	@Test
	public void BtToList() {
		LinkedList<Integer> list = HT.btToList(treeHeap);
		
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		assertEquals(list,l1);
	}
	
	@Test
	public void sortList() {
		l1.add(3);
		l1.add(2);
		l1.add(1);
		
		l2.add(1);
		l2.add(2);
		l2.add(3);
		
		assertEquals(HT.sortList(l1),l2);
	}
	
	@Test
	public void remMinTestValid() {
		IBinTree heap2 = heap1.remMinElt();
		assertTrue(HT.remMinEltTester(heap1,heap2));
	}
	
	@Test
	public void addEltTestValid() {
		IBinTree heap2 = heap1.addElt(4);
		assertTrue(HT.addEltTester(heap1, 4, heap2));
	}
	
	/*
	@Test
	public void badHeap1AddElt() {
		IBinTree heap2 = badHeap1.addElt(4);
		assertFalse(HT.addEltTester(badHeap1, 6, heap2));
	}
	
	@Test
	public void badHeap2AddElt() {
		IBinTree heap2 = badHeap2.addElt(2);
		assertTrue(HT.addEltTester(badHeap2, 2, heap2));
	}
	
	@Test
	public void badHeap3AddElt() {
		IBinTree heap2 = badHeap3.addElt(6);
		assertFalse(HT.addEltTester(badHeap3, 6, heap2));
	}
	
	@Test
	public void badHeap4AddElt() {
		IBinTree heap2 = badHeap4.addElt(2);
		assertTrue(HT.addEltTester(badHeap4, 2, heap2));
	}
	
	@Test
	public void badHeap5AddElt() {
		IBinTree heap2 = badHeap5.addElt(2);
		assertFalse(HT.addEltTester(badHeap5, 2, heap2));
	}
	
	@Test
	public void badheap1RemElt() {
		IBinTree heap2 = badHeap1.remMinElt();
		assertTrue(HT.remMinEltTester(badHeap1, heap2));
	}
	
	
	@Test
	public void badheap2RemElt() {
		IBinTree heap2 = badHeap2.remMinElt();
		assertFalse(HT.remMinEltTester(badHeap1, heap2));
	}
	
	@Test
	public void badheap3RemElt() {
		IBinTree heap2 = badHeap3.remMinElt();
		assertTrue(HT.remMinEltTester(badHeap3, heap2));
	}
	
	@Test
	public void badHeap4RemElt() {
		IBinTree heap2 = badHeap4.remMinElt();
		assertFalse(HT.remMinEltTester(badHeap4, heap2));
	}
	
	@Test
	public void badheap5RemElt() {
		IBinTree heap2 = badHeap5.remMinElt();
		assertTrue(HT.remMinEltTester(badHeap5, heap2));
	}
	
	 */

}
