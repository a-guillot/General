package Graphs;

public interface NetworkADT<T> extends GraphADT<T> {
	
	/**
	 * Insert an edge between the two vertices of the graph
	 * @param vertex1 the first vertex
	 * @param vertex2 the second vertex
	 * @param weight the weight
	 */
	public void addEdge(T vertex1, T vertex2, double weight);
	
	/**
	 * returns the weight of the shortest path in this network
	 * @param vertex1 the first vertex
	 * @param vertex2 the second vertex
	 * @return the weight of the shortest path
	 */
	public double shortestPathWeight(T vertex1, T vertex2);
}
