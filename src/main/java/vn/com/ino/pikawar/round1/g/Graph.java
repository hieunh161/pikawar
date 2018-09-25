package vn.com.ino.pikawar.round1.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {

	private Map<String, List<Vertex>> vertices;

	public Graph() {
		this.vertices = new HashMap<String, List<Vertex>>();
	}

	// add one vertex with its neigbors
	public void addVertex(String name, List<Vertex> vertex) {
		this.vertices.put(name, vertex);
	}

	// get path from start to end
	public List<String> getShortestPath(String start, String end) {
		final Map<String, Integer> distances = new HashMap<String, Integer>();
		final Map<String, Vertex> previous = new HashMap<String, Vertex>();
		PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();
		// initial states
		for (String vertex : vertices.keySet()) {
			if (vertex.equals(start)) {
				distances.put(vertex, 0);
				nodes.add(new Vertex(vertex, 0));
			} else {
				distances.put(vertex, Integer.MAX_VALUE);
				nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
			}
			previous.put(vertex, null);
		}

		while (!nodes.isEmpty()) {
			Vertex smallest = nodes.poll();
			if (smallest.getName().equals(end)) {
				final List<String> path = new ArrayList<String>();
				while (previous.get(smallest.getName()) != null) {
					path.add(smallest.getName());
					smallest = previous.get(smallest.getName());
				}
				return path;
			}
			if (distances.get(smallest.getName()) == Integer.MAX_VALUE) {
				break;
			}

			for (Vertex neighbor : vertices.get(smallest.getName())) {
				Integer alt = distances.get(smallest.getName()) + neighbor.getDistance();
				if (alt < distances.get(neighbor.getName())) {
					distances.put(neighbor.getName(), alt);
					previous.put(neighbor.getName(), smallest);
					for (Vertex n : nodes) {
						if (n.getName().equals(neighbor.getName())) {
							nodes.remove(n);
							n.setDistance(alt);
							nodes.add(n);
							break;
						}
					}
				}
			}
		}
		return new ArrayList<String>(distances.keySet());
	}
}
