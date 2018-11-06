package com.hsd.cv.upwork.network;

import java.util.HashSet;
import java.util.Set;

public class Network {

	private int elementsNumber;
	private Set<Edge> edges = new HashSet();

	public static void main(String[] args) {
		Network network = new Network(Integer.valueOf(args[0]));
		for (int i = 3; (i + 1) < args.length; i += 2) {
			network.connect(Integer.valueOf(args[i]), Integer.valueOf(args[i + 1]));
		}
		System.out.println(String.format("Nodes [%d,%d] are linked = %s", Integer.valueOf(args[1]), Integer.valueOf(args[2]), network.query(Integer.valueOf(args[1]), Integer.valueOf(args[2]))));
	}

	// interface

	public Network(int elementsNumber) {
		if (elementsNumber < 0) {
			throw new IllegalArgumentException("Number of elements should be more than or equal to 0");
		}
		this.elementsNumber = elementsNumber;
	}

	public void connect(Integer node1, Integer node2) {
		if ((node1 < 1 || node1 > elementsNumber) || (node2 < 1 || node2 > elementsNumber)) {
			throw new IllegalArgumentException(String.format("Edge [%d,%d] is invalid for network with %d elements", node1, node2, elementsNumber));
		}
		edges.add(new Edge(node1, node2));
	}

	public boolean query(Integer node1, Integer node2) {
		if ((node1 < 1 || node1 > elementsNumber) || (node2 < 1 || node2 > elementsNumber)) {
			throw new IllegalArgumentException(String.format("Edge [%d,%d] is invalid for network with %d elements", node1, node2, elementsNumber));
		}

		Set<Integer> nodes = new HashSet();
		nodes.add(node1);
		return queryImpl(nodes, nodes, node2);
	}

	// implementation

	private boolean queryImpl(Set<Integer> nodes, Set<Integer> newNodes, Integer finalNode) {
		if (newNodes.contains(finalNode)) {
			return true;
		} else if (newNodes.isEmpty()) {
			return false;
		}
		
		Set<Integer> newNodesCurrent = new HashSet();
		for (Integer node : newNodes) {
			for (Edge edge : edges) {
				Integer edgeNode = NetworkUtils.getPairNodeOfEdge(edge, node);
				if (edgeNode != null) {
					newNodesCurrent.add(edgeNode);
				}
			}
		}
		newNodesCurrent.removeAll(nodes);
		nodes.addAll(newNodesCurrent);
		return queryImpl(nodes, newNodesCurrent, finalNode);
	}
	
}
