package net.smartkyc.demo.domino.model;

import java.util.LinkedList;

public class ValidDominoChain {

	LinkedList<DominoItem> chain;
	Integer leftMost;
	Integer rightMost;
	Integer value;
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public LinkedList<DominoItem> getChain() {
		return chain;
	}
	public void setChain(LinkedList<DominoItem> chain) {
		this.chain = chain;
	}
	public Integer getLeftMost() {
		return leftMost;
	}
	public void setLeftMost(Integer leftMost) {
		this.leftMost = leftMost;
	}
	public Integer getRightMost() {
		return rightMost;
	}
	public void setRightMost(Integer rightMost) {
		this.rightMost = rightMost;
	}
	@Override
	public String toString() {
		return "ValidDominoChain [chain=" + chain + ", leftMost=" + leftMost + ", rightMost=" + rightMost + ", value="
				+ value + "]";
	}
	
	
	
}
