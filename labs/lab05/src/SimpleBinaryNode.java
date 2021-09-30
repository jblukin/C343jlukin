// C343 / Fall 2021
//
// a very simple, starting binary node class;
// it's so simple, it's named SimpleBinaryNode.

public class SimpleBinaryNode <E extends Comparable<?super E>> {
	private E value;                     // value-only, no key
	private SimpleBinaryNode<E> left;    // left child
	private SimpleBinaryNode<E> right;   // right child
	
	public SimpleBinaryNode(E e) {
		value = e;
		left = right = null;
	}
	
	public void setLeft(SimpleBinaryNode<E> node) {
		left = node;
	}
	
	public void setRight(SimpleBinaryNode<E> node) {
		right = node;
	}
	
	public boolean find(E q) {
		
		if(value.compareTo(q) < 0) {
			
			if(right == null) {
				
				return false;
				
			} else return right.find(q);
			
		} else if(value.compareTo(q) > 0) {
			
			if(left == null) {
				
				return false;
				
			} else return left.find(q);
			
		} else if(value.compareTo(q) == 0) {
			
			return true;
			
		} else return false;
		
	}
	
	public static void main(String[] args) {
		
		SimpleBinaryNode<Integer> root = new SimpleBinaryNode<Integer>(7);
		SimpleBinaryNode<Integer> node1 = new SimpleBinaryNode<Integer>(29);
		SimpleBinaryNode<Integer> node2 = new SimpleBinaryNode<Integer>(36);
		SimpleBinaryNode<Integer> node3 = new SimpleBinaryNode<Integer>(30);
		SimpleBinaryNode<Integer> node4 = new SimpleBinaryNode<Integer>(31);
		SimpleBinaryNode<Integer> node5 = new SimpleBinaryNode<Integer>(22);
		SimpleBinaryNode<Integer> node6 = new SimpleBinaryNode<Integer>(33);
		SimpleBinaryNode<Integer> node7 = new SimpleBinaryNode<Integer>(40);
		SimpleBinaryNode<Integer> node8 = new SimpleBinaryNode<Integer>(50);
		SimpleBinaryNode<Integer> node9 = new SimpleBinaryNode<Integer>(52);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node5);
		node2.setLeft(node3);
		node3.setRight(node4);
		node4.setRight(node6);
		node2.setRight(node7);
		node7.setRight(node8);
		node8.setRight(node9);
		
		// find() needs to be implemented
		System.out.println("is 36 found in the tree: " + root.find(36));
		// find(36) should return true
		System.out.println("is 103 found in the tree: " + root.find(103));
		// find(103) should return false
		System.out.println("is 52 found in the tree: " + root.find(52));
		System.out.println("is 84 found in the tree: " + root.find(84));
		System.out.println("is 31 found in the tree: " + root.find(31));
		
	} // end of main()
	
} // end of SimpleBinaryNode class