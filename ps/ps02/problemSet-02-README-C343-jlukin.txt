Problem Set 02 Asnwers

A:

1. printLevelOrder {
	getHeight
	level = 1
	while level<height
		if level > 1
			recursive call
				print node.left
				print node.right
				level--
		height++
   }



B:

1. The BST property is defined as only allowing equal values into the right subtree as if it allowed both, you would have to run down both trees to check for duplicates and/or the equal value itself which would ruin the efficiency of a BST.

2. 			 15
			   /    \
			  5     20
			   \   /  \    
		       7  18   25
		         / 
		        16  
		                    

3. a) An arraylist in sorted order because the size is predetermined and using a binary search will allow for O(logn) search time because we know that each half of data will always have values entirely lower or higher than the other.

   b) A linkedlist of unsorted records would be best as insertion time is O(1) and since there are only 10 searches being done there won't be much time wasted as worst case search is O(n)

   c) A linkedlist of unsorted data because insertion would be O(1) and the data size is small so the searches worst case is O(n)

   d) A BST because it will be balanced and the data size is small so and the search is large the O(logn) of insertion will be counteracted by the speed of O(logn) in the million searches



C:

1. The smallest element in a max heap will be found in a leaf node.

2.   10 9 12 7 4 1 8 3 5 2
                          

 			     12
			   /    \
			  9     10
			 / \    / \    
		    7   4   1  8
		       / \  /
		      3  5  2


_________________________________________________________________________________________________________________________________________


















			     10
			   /    \
			  5     12
			 / \    / \    
		    	3   2   1  8
		       / \  /
		      7  9  4

			     10
			   /    \
			  5     12
			 / \    / \    
		    	3   4   1  8
		       / \  /
		      7  9  2

			     10
			   /    \
			  5     12
			 / \    / \    
		    	7   4   1  8
		       / \  /
		      3  9  2

 			     10
			   /    \
			  7     12
			 / \    / \    
		    	5   4   1  8
		       / \  /
		      3  9  2

			     10
			   /    \
			  7     12
			 / \    / \    
		    	9   4   1  8
		       / \  /
		      3  5  2

			     10
			   /    \
			  9     12
			 / \    / \    
		    	7   4   1  8
		       / \  /
		      3  5  2

			     12
			   /    \
			  9     10
			 / \    / \    
		    	7   4   1  8
		       / \  /
		      3  5  2



