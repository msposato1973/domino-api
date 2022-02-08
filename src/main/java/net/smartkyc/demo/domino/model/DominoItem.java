package net.smartkyc.demo.domino.model;

import java.util.Objects;

public class DominoItem {
	
	private int left;
	private int right;
	
	DominoItem(final int left, final int right) {
		super();
		this.left = left;
		this.right = right;
	}
	

	int getLeft() {
		return this.left;
	}
	
	int getRight() {
		return this.right;
	}
	
	
	@Override
	public String toString() {
		return "DominoItem [left=" + left + ", right=" + right + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(left, right);
	}


	@Override
	public boolean equals(final Object item) {
		final DominoItem otherItem = (DominoItem) item;
		return (this.getLeft() == otherItem.getLeft() && this.getRight() == otherItem.getRight())
				|| (this.getLeft() == otherItem.getRight() && this.getRight() == otherItem.getLeft());
	}
	
	
}
