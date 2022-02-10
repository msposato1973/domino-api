package net.smartkyc.demo.domino.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DominoItem {

	private Integer first;
	private Integer second;
	
	@JsonIgnore
	private Boolean visited;

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	public DominoItem(Integer first, Integer second) {
		super();
		this.first = first;
		this.second = second;
		this.visited = false;
	}

	public DominoItem() {
		this.visited = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		result = prime * result + ((visited == null) ? 0 : visited.hashCode());
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
		DominoItem other = (DominoItem) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		if (visited == null) {
			if (other.visited != null)
				return false;
		} else if (!visited.equals(other.visited))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DominoItem [first=" + first + ", second=" + second + ", visited=" + visited + "]";
	}
	
	

}
