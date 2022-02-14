package net.smartkyc.demo.domino.model;

import java.util.List;

public class DominoResponse {
	 
	public DominoResponse(List<DominoItem> dominoListChain, DominoItem dominoItem, int total) {
		super();
		this.dominoListChain = dominoListChain;
		this.dominoItem = dominoItem;
		this.total = total;
	}
	
	public DominoResponse() {
		super();
	}
	
	private List<DominoItem> dominoListChain ;
	private DominoItem dominoItem;
	private int total;
	
	public List<DominoItem> getDominoListChain() {
		return dominoListChain;
	}
	public void setDominoListChain(List<DominoItem> dominoListChain) {
		this.dominoListChain = dominoListChain;
	}
	public DominoItem getDominoItem() {
		return dominoItem;
	}
	public void setDominoItem(DominoItem dominoItem) {
		this.dominoItem = dominoItem;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
