// C343 / Fall 2021
//
// HuffmanTree - a class to implement Huffman's Algorithm

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class HuffmanTree<Key, E> {
	private MinHeap<Integer, String> heap;        // heap for building the tree
	private BinaryNodeKV<Integer, String> root;   // root node for traversal
	private Dictionary<String, String> codeTable; // huffman letter<->code table
	private Dictionary<String, Integer> codeFreq; // huffman letter<->frequency table
	
	public HuffmanTree(String letters, int[] weights) {
		init(letters, weights);
		buildTree();
		codeTable = new Hashtable<String, String>();
		buildCodeTable();
		summary();
	}
	
	private void init(String letters, int[] weights) {
		codeFreq = new Hashtable<String, Integer>();
		for (int i = 0; i < letters.length(); i++)
			codeFreq.put(letters.substring(i, i + 1), weights[i]);
		int maxNum = letters.length();
		// BinaryNodeKV<Integer, String>[] nodes = (BinaryNodeKV<Integer, String>[]) new Object[maxNum];
		@SuppressWarnings("unchecked")
		BinaryNodeKV<Integer, String>[] nodes = new BinaryNodeKV[maxNum];
		for (int i = 0; i < maxNum; i++) {
			nodes[i] = new BinaryNodeKV<Integer, String>(weights[i], letters.substring(i, i + 1));
		}
		heap = new MinHeap<Integer, String>(maxNum, maxNum, nodes);
		heap.display();
	}
	
	private void buildTree() {
		while (heap.length() > 1) {
			BinaryNodeKV<Integer, String> node1 = heap.removeMin();
			BinaryNodeKV<Integer, String> node2 = heap.removeMin();
			BinaryNodeKV<Integer, String> newnode = new BinaryNodeKV<Integer, String>(node1.getKey() + node2.getKey(), " ");
			newnode.setLeft(node1);
			newnode.setRight(node2);
			heap.insert(newnode);
			heap.display();
		}
		root = heap.removeMin();
		System.out.println("Huffman tree built. Root weight = " + root.getKey());
	}
	
	public void summary() {
		if (codeTable.isEmpty()) {
			System.out.println("Summary can't be provided. The Huffman Code Table is empty!");
			return;
		}
		// display the code & compute the sum of weighted path lengths
		Enumeration<String> keys = codeFreq.keys();
		int sumOfWeightedPath = 0;
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println("Letter: " + key + " " + codeTable.get(key));
			sumOfWeightedPath += codeTable.get(key).length() * codeFreq.get(key);
		}
		System.out.println("Total letters: " + root.getKey());
		System.out.println("Sum of weighted path lengths: " + sumOfWeightedPath);
		System.out.println("Average code length: " + sumOfWeightedPath * 1.0 / root.getKey());
	}
	
	// Functionality 1: get the Huffman code by traversing the tree.
	//
	// Each leaf node is a letter, and the corresponding path is the code.
	// For simplicity, represent Huffman codes by using strings of "0" and "1", not bits.
	private void buildCodeTable() {
		
		String code = "";
		
		buildCodeTable(root, code);
		
	}
	
	private void buildCodeTable(BinaryNodeKV node, String c) {
		
		if(node.isLeaf()) {
			
			codeTable.put((String)node.getValue(), c);
			
		}
		
		if(node.getLeft() != null) {
			
			buildCodeTable(node.getLeft(), c + "0");

		}
		
		if(node.getRight() != null) {
			
			buildCodeTable(node.getRight(), c + "1");
			
		}
		
	}
	
	// Functionality 2: encode a message
	//
	public String encode(String inStr) {
		if (codeTable.isEmpty()) {
			System.out.println("Encoding not possible. Huffman Code Table empty!");
			return "";
		}
		String outCode = "";
		for (int i = 0; i < inStr.length(); i++) {
			String letter = inStr.substring(i, i + 1);
			// here we use the codeTable built by buildCodeTable()
			outCode += codeTable.get(letter);
		}
		return outCode;
	}
	
	// Functionality 3: decode a message
	//
	public String decode(String inCode) {
		String outStr = "";
		BinaryNodeKV<Integer, String> currentNode = root;
		if (currentNode.isLeaf()) {
			System.out.println("Decoding not possible. Huffman Tree empty!");
			return "";
		}
		
		 System.out.println("about to decode the Huffman code: " + inCode);
		 System.out.println("using the tree: " + root.inorder());
		
		for (int i = 0; i < inCode.length(); i++) {
			
			char c = inCode.charAt(i);
			
			if (c == '0') {
				
				currentNode = currentNode.getLeft();
				
			} else {
				
				currentNode = currentNode.getRight();
			}
			
			if(currentNode.isLeaf()) {
				
				outStr += currentNode.getValue();
				currentNode = root;
				
			}
			
		}
		
		return outStr;
	}
	
	public static void main(String[] argv) {
		int[] weights = {2, 7, 24, 32, 37, 42, 42, 120};
		String letters = "ZKMCDLUE";
		HuffmanTree<Integer, String> tree = new HuffmanTree<Integer, String>(letters, weights);
		System.out.println("DEED" + " encoded as " + tree.encode("DEED"));
		System.out.println("0110111111011001110111101" + " decodes into " + tree.decode("0110111111011001110111101"));
	}
	
} // public class HuffmanTree