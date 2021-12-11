// C343 Fall 2021
//
// a simple implementation for graphs with adjacency lists

// Lab 10 starter file

import java.util.*;

public class AdjGraph implements Graph {
	
	// is it a directed graph (true or false) :
	private boolean digraph;
	
	private int totalNodes;
	// all the nodes in the graph:
	private Vector<String> nodeList;
	
	private int totalEdges;
	// all the adjacency lists, one for each node in the graph:
	private Vector<LinkedList<Integer>>  adjList;
	
	// all the weights of the edges, one for each node in the graph:
	private Vector<LinkedList<Integer>> adjWeight;
	
	// every visited node:
	private Vector<Boolean> visited;
	
	// list of nodes pre-visit:
	private Vector<Integer> nodeEnum;
	
	public AdjGraph() {
		init();
	}
	
	public AdjGraph(boolean ifdigraph) {
		init();
		digraph = ifdigraph;
	}
	
	public void init() {
		nodeList = new Vector<String>();
		adjList = new Vector<LinkedList<Integer>>();
		adjWeight = new Vector<LinkedList<Integer>>();
		visited = new Vector<Boolean>();
		nodeEnum = new Vector<Integer>();
		totalNodes = totalEdges = 0;
		digraph = false;
	}
	
	// set vertices:
	public void setVertices(String[] nodes) {
		for (int i = 0; i < nodes.length; i ++) {
			nodeList.add(nodes[i]);
			adjList.add(new LinkedList<Integer>());
			adjWeight.add(new LinkedList<Integer>());
			visited.add(false);
			totalNodes ++;
		}
	}
	
	// add a vertex:
	public void addVertex(String label) {
		nodeList.add(label);
		visited.add(false);
		adjList.add(new LinkedList<Integer>());
		adjWeight.add(new LinkedList<Integer>());
		totalNodes ++;
	}
	
	public int getNode(String node) {
		for (int i = 0; i < nodeList.size(); i ++) {
			if (nodeList.elementAt(i).equals(node)) return i;
		}
		return -1;
	}
	
	// return the number of vertices:
	public int length() {
		return nodeList.size();
	}
	
	// add edge from v1 to v2:
	public void setEdge(int v1, int v2, int weight) {
		LinkedList<Integer> tmp = adjList.elementAt(v1);
		if (adjList.elementAt(v1).contains(v2) == false) {
			tmp.add(v2);
			adjList.set(v1,  tmp);
			totalEdges ++;
			LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
			tmp2.add(weight);
			adjWeight.set(v1,  tmp2);
		}
	}
	
	public void setEdge(String v1, String v2, int weight) {
		if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
			// add edge from v1 to v2:
			setEdge(getNode(v1), getNode(v2), weight);
			// for undirected graphs, add edge from v2 to v1 as well:
			if (digraph == false) {
				setEdge(getNode(v2), getNode(v1), weight);
			}
		}
	}
	
	// keep track whether a vertex has been visited or not,
	//    for graph traversal purposes:
	public void setVisited(int v) {
		visited.set(v, true);
		nodeEnum.add(v);
	}
	
	public boolean ifVisited(int v) {
		return visited.get(v);
	}
	
	
	public LinkedList<Integer> getNeighbors(int v) {
		return adjList.get(v);
	}
	
	public int getWeight(int v, int u) {
		LinkedList<Integer> tmp = getNeighbors(v);
		LinkedList<Integer> weight = adjWeight.get(v);
		if (tmp.contains(u)) {
			return weight.get(tmp.indexOf(u));
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
	
	
	// clean up before traversing the graph:
	public void clearWalk() {
		nodeEnum.clear();
		for (int i = 0; i < nodeList.size(); i ++)
			visited.set(i, false);
	}
	
	public void walk(String method) {
		clearWalk();
		// traverse the graph:
		for (int i = 0; i < nodeList.size(); i ++) {
			if (ifVisited(i) == false) {
				if (method.equals("BFS")) {
					BFS(i);      // i is the start node
				} else if (method.equals("DFS")) {
					DFS(i); // i is the start node
				} else {
					System.out.println("unrecognized traversal order: " + method);
					System.exit(0);
				}
			}
		}
		System.out.println(method + ":");
		displayEnum();
	}
	
	// Lab 10 TODO:
	//
	// write your method topologicalSortWithQueue() here.
	//
	public void topologicalSortWithQueue(Graph g) {
		
		int[] indegree = new int[g.length()];
		
		for (int i = 0; i < g.length(); i++) {
			
			LinkedList<Integer> temp = (LinkedList<Integer>) adjList.get(i);
			
			for (int node : temp) {
				
				indegree[node]++;
				
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0; i < g.length(); i++) {
			
			if (indegree[i] == 0) {
				
				q.add(i);
				
			}
			
		}
		
		Vector<Integer> topOrder = new Vector<Integer>();
		
		while (!q.isEmpty()) {
			
			int u = q.poll();
			
			topOrder.add(u);
			
			for (int node : adjList.get(u)) {
				
				if (--indegree[node] == 0) {
					
					q.add(node);
					
				}
				
			}

		}
		
		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}
	
	
	
	public void DFS(int v) {
		setVisited(v);
		LinkedList<Integer> neighbors = adjList.elementAt(v);
		for (int i = 0; i < neighbors.size(); i ++) {
			int v1 = neighbors.get(i);
			if (ifVisited(v1) == false) {
				DFS(v1);
			}
		}
	}
	
	public void BFS(int s) {
		ArrayList<Integer> toVisit = new ArrayList<Integer>();
		toVisit.add(s);
		while (toVisit.size() > 0) {
			int v = toVisit.remove(0);   // first-in, first-visit
			setVisited(v);
			LinkedList<Integer> neighbors = adjList.elementAt(v);
			for (int i = 0; i < neighbors.size(); i ++) {
				int v1 = neighbors.get(i);
				if ( (ifVisited(v1) == false) && (toVisit.contains(v1) == false) ) {
					toVisit.add(v1);
				}
			}
		}
	}
	
	public void display() {
		System.out.println("total nodes: " + totalNodes);
		System.out.println("total edges: " + totalEdges);
	}
	
	public void displayEnum() {
		for (int i = 0; i < nodeEnum.size(); i ++) {
			System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
		}
		System.out.println();
	}

	// Lab 10 TODO:
	
	// write your new main() method here:
	public static void main(String[] args) {
		
		AdjGraph g1 = new AdjGraph(true);
		String[] nodes1 = {"A", "B", "C", "D", "E"};
		int weight = 1;
		g1.setVertices(nodes1);
		g1.setEdge("A", "B", weight);
		g1.setEdge("B", "C", weight);
		g1.setEdge("C", "D", weight);
		g1.setEdge("A", "C", weight);
		
		g1.topologicalSortWithQueue(g1);
		
		System.out.println();
		System.out.println();
		
		AdjGraph g2 = new AdjGraph(true);
		String[] nodes2 = {"j1", "j2", "j3", "j4", "j5", "j6", "j7"};
		g2.setVertices(nodes2);
		g2.setEdge("j1", "j2", 1);
		g2.setEdge("j1", "j3", 1);
		g2.setEdge("j2", "j6", 1);
		g2.setEdge("j2", "j5", 1);
		g2.setEdge("j2", "j4", 1);
		g2.setEdge("j3", "j4", 1);
		g2.setEdge("j4", "j5", 1);
		g2.setEdge("j5", "j7", 1);
		
		g2.topologicalSortWithQueue(g2);
		
		System.out.println();
		System.out.println();
		
		AdjGraph g3 = new AdjGraph(true);
		String[] nodes3 = {"a", "b", "c", "d", "e", "f", "g", "h"};
		g3.setVertices(nodes3);
		g3.setEdge("a", "b", 1);
		g3.setEdge("b", "c", 1);
		g3.setEdge("c", "d", 1);
		g3.setEdge("c", "e", 1);
		g3.setEdge("d", "f", 1);
		g3.setEdge("d", "g", 1);
		g3.setEdge("e", "h", 1);
		
		g3.topologicalSortWithQueue(g3);

	}
	
	
	
} // end of class AdjGraph