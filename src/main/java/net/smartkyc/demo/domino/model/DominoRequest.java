package net.smartkyc.demo.domino.model;

import java.util.List;

public class DominoRequest {
	
	private DominoItem dominoItem;
	private List<DominoItem> dominoList;
	
	public DominoRequest(DominoItem dominoItem, List<DominoItem> dominoList) {
		super();
		this.dominoItem = dominoItem;
		this.dominoList = dominoList;
	}
	
	public DominoItem getDominoItem() {
		return dominoItem;
	}
	public void setDominoItem(DominoItem dominoItem) {
		this.dominoItem = dominoItem;
	}
	public List<DominoItem> getDominoList() {
		return dominoList;
	}
	public void setDominoList(List<DominoItem> dominoList) {
		this.dominoList = dominoList;
	}
	
}
