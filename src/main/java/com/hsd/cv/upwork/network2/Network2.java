package com.hsd.cv.upwork.network2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Network2 {

	private int elementsNumber;
	private Map<Integer, List<Integer>> edges = new HashMap();

	public static void main(String[] args) {
		Network2 network = new Network2(Integer.valueOf(args[0]));
		for (int i = 3; (i + 1) < args.length; i += 2) {
			network.connect(Integer.valueOf(args[i]), Integer.valueOf(args[i + 1]));
		}
		System.out.println(String.format("Nodes [%d,%d] are linked = %s", Integer.valueOf(args[1]), Integer.valueOf(args[2]), network.query(Integer.valueOf(args[1]), Integer.valueOf(args[2]))));
		System.out.println(String.format("Nodes [%d,%d] are linked = %s", 1, 4, network.query(1, 4)));
		System.out.println(String.format("Nodes [%d,%d] are linked = %s", 4, 1, network.query(4, 1)));
		System.out.println(String.format("Nodes [%d,%d] are linked = %s", 1, 2, network.query(1, 2)));
		System.out.println(String.format("Nodes [%d,%d] are linked = %s", 1, 8, network.query(1, 8)));
		System.out.println(String.format("Nodes [%d,%d] are linked = %s", 7, 8, network.query(7, 8)));
	}

	// interface

	public Network2(int elementsNumber) {
		if (elementsNumber < 0) {
			throw new IllegalArgumentException("Number of elements should be more than or equal to 0");
		}
		this.elementsNumber = elementsNumber;
	}

	public void connect(Integer node1, Integer node2) {
		if ((node1 < 1 || node1 > elementsNumber) || (node2 < 1 || node2 > elementsNumber)) {
			throw new IllegalArgumentException(String.format("Edge [%d,%d] is invalid for network with %d elements", node1, node2, elementsNumber));
		}
		if (!edges.containsKey(node1)) {
			edges.put(node1, new LinkedList());
		}
		if (!edges.containsKey(node2)) {
			edges.put(node2, new LinkedList());
		}
		edges.get(node1).add(node2);
		edges.get(node2).add(node1);
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
			if (edges.containsKey(node)) {
				for (Integer edgeNode : edges.get(node)) {
					newNodesCurrent.add(edgeNode);
				}
			}
		}
		newNodesCurrent.removeAll(nodes);
		nodes.addAll(newNodesCurrent);
		return queryImpl(nodes, newNodesCurrent, finalNode);
	}
	
}
