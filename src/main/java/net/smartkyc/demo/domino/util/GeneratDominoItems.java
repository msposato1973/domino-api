package net.smartkyc.demo.domino.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.smartkyc.demo.domino.model.DominoItem;
public class GeneratDominoItems {
	
	private int min_val = 1;
	private int max_val = 10;
	private int numElem = 8;
	private Random randomData = null;
	List<DominoItem> allDominos  = null;
	
	GeneratDominoItems() {
		randomData = new Random();
		allDominos = new ArrayList<DominoItem>();
	}
	
	private DominoItem getItemDominus() {
		 
		int left = randomData.nextInt(min_val, max_val);
		int right = randomData.nextInt(min_val, max_val);
		
		return new DominoItem(left, right);
	}
	
	public List<DominoItem> generateListDominoItem(){
		
		while(!(allDominos.size() <= numElem)){
			DominoItem dItem = getItemDominus();
			if(!allDominos.contains(dItem)) allDominos.add(dItem);
		}
	
		return allDominos;
	}
	
}
