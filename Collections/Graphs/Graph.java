package Graphs;

import java.util.Iterator;

public class Graph<T> implements GraphADT<T> {

	protected final static int DEFAULT_CAPACITY = 10;
	protected int numVertices;
	protected boolean[][] adjMatrix;
	protected T[] vertices;
	
	public Graph() {
		numVertices = 0;
		this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
		this.vertices = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	@Override
	public void addVertex(T vertex) {
		if (numVertices == vertices.length)
			expandCapacity();
		
		vertices[numVertices] = vertex;
		
		for (int i = 0; i < numVertices; i++) {
			adjMatrix[i][numVertices] = false;
			adjMatrix[numVertices][i] = false;
		}
		
		numVertices++;
	}

	private void expandCapacity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVertex(T vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(T vertex1, T vertex2) {
		addEdge(getIndex(vertex1), getIndex(vertex2));
	}

	private void addEdge(int index1, int index2) {
		if (indexIsValid(index1) && indexIsValid(index2)) {
			adjMatrix[index1][index2] = true;
			adjMatrix[index2][index1] = true;
		}
	}

	private boolean indexIsValid(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	private int getIndex(T vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeEdge(T vertex1, T vertex2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<T> iteratorBFS(T startVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorDFS(T startVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
