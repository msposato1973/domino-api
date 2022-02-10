package net.smartkyc.demo.domino.model;

import java.util.List;

public class DominoRequest {

	private DominoItem initialDominoItem;
	private List<DominoItem> dominoItems;
	public DominoItem getInitialDominoItem() {
		return initialDominoItem;
	}
	public void setInitialDominoItem(DominoItem initialDominoItem) {
		this.initialDominoItem = initialDominoItem;
	}
	public List<DominoItem> getDominoItems() {
		return dominoItems;
	}
	public void setDominoItems(List<DominoItem> dominoItems) {
		this.dominoItems = dominoItems;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dominoItems == null) ? 0 : dominoItems.hashCode());
		result = prime * result + ((initialDominoItem == null) ? 0 : initialDominoItem.hashCode());
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
		DominoRequest other = (DominoRequest) obj;
		if (dominoItems == null) {
			if (other.dominoItems != null)
				return false;
		} else if (!dominoItems.equals(other.dominoItems))
			return false;
		if (initialDominoItem == null) {
			if (other.initialDominoItem != null)
				return false;
		} else if (!initialDominoItem.equals(other.initialDominoItem))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DominoRequest [initialDominoItem=" + initialDominoItem + ", dominoItems=" + dominoItems + "]";
	}
	
	
}
