package com.hsd.cv.upwork.network;

public class NetworkUtils {

	public static Integer getPairNodeOfEdge(Edge edge, Integer node) {
		if (edge.getNode1().equals(node)) {
			return edge.getNode2();
		} else if (edge.getNode2().equals(node)) {
			return edge.getNode1();
		}
		return null;
	}
	
}
