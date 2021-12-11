// C343 Fall 2021
//
// a simple interface for graphs


import java.util.LinkedList;

public interface Graph {
	void init();
	int length();
	void setVertices(String[] nodes);
	void addVertex(String node);
	void setEdge(int v1, int v2, int weight);
	void setEdge(String v1, String v2, int weight);
	void setVisited(int v);
	boolean ifVisited(int v);
	
	LinkedList<Integer> getNeighbors(int v);
	int getWeight(int v, int u);
	
	void clearWalk();
	void walk(String order);
	void DFS(int s);    // depth first
	void BFS(int s);    // breath first
	void display();     // display information
	void displayEnum(); // display vertex enumeration
}