package com.domins.domino.api.model;

import java.util.List;

public class DominoResponse {
	 
	public DominoResponse(List<DominoItem> dominoListChain, int total) {
		super();
		this.dominoListChain = dominoListChain;
		this.total = total;
	}
	
	public DominoResponse() {
		super();
	}
	
	private List<DominoItem> dominoListChain ;
	private int total;
	
	public List<DominoItem> getDominoListChain() {
		return dominoListChain;
	}
	public void setDominoListChain(List<DominoItem> dominoListChain) {
		this.dominoListChain = dominoListChain;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
