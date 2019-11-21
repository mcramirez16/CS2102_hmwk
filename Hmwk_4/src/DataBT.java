public class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;

 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }
 
 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }

 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }

 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }

@Override
public int getNode() {
	// TODO Auto-generated method stub
	return this.data;
}

@Override
public IBinTree getLeft() {
	// TODO Auto-generated method stub
	return this.left;
}

@Override
public IBinTree getRight() {
	// TODO Auto-generated method stub
	return this.right;
}

@Override
public boolean isHeap() {// determines if a binary tree is a heap
	boolean updateBool = false;
	
	if(this.size() == 0) {
		updateBool = true;//returns false when the BT is empty;
	}
	else {
		if(this.getNode() < this.getLeft().getNode()) {
			updateBool = true;
			if(this.getLeft().isHeap()) {
				if(this.getNode() < this.getRight().getNode()) {
					updateBool = true;
					if(this.getRight().isHeap()) {
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
}