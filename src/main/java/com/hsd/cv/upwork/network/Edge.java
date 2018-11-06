package com.hsd.cv.upwork.network;

public class Edge {

	private Integer node1;
	private Integer node2;

	public Edge(Integer node1, Integer node2) {
		if (node1 < node2) {
			this.node1 = node1;
			this.node2 = node2;
		} else {
			this.node1 = node2;
			this.node2 = node1;
		}
	}

	public Integer getNode1() {
		return node1;
	}

	public void setNode1(Integer node1) {
		this.node1 = node1;
	}

	public Integer getNode2() {
		return node2;
	}

	public void setNode2(Integer node2) {
		this.node2 = node2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node1 == null) ? 0 : node1.hashCode());
		result = prime * result + ((node2 == null) ? 0 : node2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (node1 == null) {
			if (other.node1 != null)
				return false;
		} else if (!node1.equals(other.node1))
			return false;
		if (node2 == null) {
			if (other.node2 != null)
				return false;
		} else if (!node2.equals(other.node2))
			return false;
		return true;
	}

}
