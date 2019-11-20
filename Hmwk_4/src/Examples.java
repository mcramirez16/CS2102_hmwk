import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

	HeapChecker HT = new HeapChecker();
	HeapChecker2 HT2 = new HeapChecker2();
	
	IHeap left1 = new TestHeap(3,new MtHeap(),new MtHeap());
	IHeap right1 = new TestHeap(5,new MtHeap(),new MtHeap());
	TestHeap heap1 = new TestHeap(2, left1, right1);
	IBinTree leftBT = new DataBT(2,new MtBT(),new MtBT());
	IBinTree rightBT = new DataBT(3,new MtBT(),new MtBT());
	IBinTree treeHeap = new DataBT(1,leftBT,rightBT);
	IBinTree treeNotHeap = new DataBT(5,leftBT,rightBT);
	
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
	
	

}
