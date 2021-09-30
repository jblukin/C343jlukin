// C343 / Fall 2021
//
// a very simple, starting BST class;
// it's so simple, it's named SimpleBST.


public class SimpleBST <K extends Comparable<?super K>> {
	BinaryNode<K> root;
	BinaryNode<K> current;
	
	// TODO for C343/Fall 2021 - Lab 05 Task B
	// "unbalanced" is used for balance checking:
	//    if a node is unbalanced, the tree will be unbalanced
	BinaryNode<K> unbalanced = null;
	
	public SimpleBST() {
		root = null;
		current = null;
	}
	public void build(K[] keys) {
		for (int i = 0; i < keys.length; i ++)
			insert(keys[i]);
	}
	public void insert(K k) {
		BinaryNode<K> tmpNode = new BinaryNode<K>(k);
		if (root == null) {
			root = current = tmpNode;
		} else {
			current = search(root, k);
			if (k.compareTo(current.getKey()) < 0)
				current.setLeft(tmpNode);
			else
				current.setRight(tmpNode);
		}
	}
	public BinaryNode<K> search(BinaryNode<K> entry, K k) {
		if (entry == null) {
			return null;
		} else {
			// update the size of the subtree by one:
			entry.setSize(entry.getSize() + 1);
			if (entry.isLeaf())
				return entry;
			if (k.compareTo(entry.getKey()) < 0) {
				if (entry.getLeft() != null)
					return search(entry.getLeft(), k);
				else
					return entry;
			} else {
				if (entry.getRight() != null)
					return search(entry.getRight(), k);
				else
					return entry;
			}
		}
	}
	public void display() {
		if (root == null) {
			return;
		}
		System.out.println("Pre-order enumeration: key(size-of-the-subtree)");
		traversePreOrder(root);
		System.out.println();
		System.out.println();
		System.out.println("Post-order enumeration: key(size-of-the-subtree)");
		traversePostOrder(root);
		System.out.println();
		System.out.println();
		System.out.println("In-order enumeration: key(size-of-the-subtree)");
		traverseInOrder(root);
		System.out.println();
		System.out.println();
	}
	public void traversePreOrder(BinaryNode<K> entry) {
		System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
		if (entry.getLeft() != null) traversePreOrder(entry.getLeft());
		if (entry.getRight() != null) traversePreOrder(entry.getRight());
	}
	
	// TODO for C343/Fall 2021 - Lab 05 Task B
	// implement balanceCheck(),
	//   and you may write heightAtNode(node) as helper function
	
	public boolean balanceCheck(BinaryNode<K> root) {
		
		if(root == null) {
			
			return true;
			
		}
		
		if(balanceCheck(root.getRight()) && balanceCheck(root.getLeft()) && Math.abs(heightAtNode(root)) <= 1) {
			
			return true;
			
		}
		
		return false;
	
	}
	
	
	public int heightAtNode(BinaryNode<K> node) {
		if(node == null)
			return 0;
		return Math.max(heightAtNode(node.getLeft()), heightAtNode(node.getRight()));
		
	}
	
	// TODO for C343/Fall 2021 - Lab 05 Task C
	// implement traverseInOrder()
	// implement traversePostOrder()
	
	public void traverseInOrder(BinaryNode<K> root) {
		if (root == null) return;
		if (root.getLeft() != null) traverseInOrder(root.getLeft());
		System.out.print(root.getKey() + "(" + root.getSize() + ") ");
		if (root.getRight() != null) traverseInOrder(root.getRight());
	}
	
	public void traversePostOrder(BinaryNode<K> root) {
		if (root == null) return;
		if (root.getLeft() != null) traversePostOrder(root.getLeft());
		if (root.getRight() != null) traversePostOrder(root.getRight());
		System.out.print(root.getKey() + "(" + root.getSize() + ") ");
	}
	
	public static void main(String[] argv) {
		SimpleBST<Integer> tree = new SimpleBST<Integer>();
		Integer[] keys = {2, 4, 6, 8, 10, 3, 5, 7, 9, 11, 12, -10, -20, 100};
		tree.build(keys);
		tree.display();
		
		
		// TODO for C343/Fall 2021 - Lab Task 05 Task B and C
		// see instructions
		
		System.out.println(tree.balanceCheck(tree.root));
		
	}
}