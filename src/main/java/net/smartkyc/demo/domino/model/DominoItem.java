package net.smartkyc.demo.domino.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DominoItem {

	private Integer first;
	private Integer second;
	
	@JsonIgnore
	private boolean used;

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

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		result = prime * result + (used ? 1231 : 1237);
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
		if (used != other.used)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DominoItem [first=" + first + ", second=" + second + ", used=" + used + "]";
	}

	public DominoItem(Integer first, Integer second) {
		super();
		this.first = first;
		this.second = second;
		this.used = false;
	}

	public DominoItem() {
		this.used = false;
	}
	
}
