package net.smartkyc.demo.domino.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import net.smartkyc.demo.domino.model.DominoItem;
public class GeneratDominoItems {
	
	private int min_val = 1;
	private int max_val = 10;
	private int numElem = 0;
	private Random randomData = null;
	private List<DominoItem> allDominos  = null;
	
	GeneratDominoItems() {
		numElem = 8;
		randomData = new Random();
		allDominos = new ArrayList<DominoItem>();
	}
	
	GeneratDominoItems(int numElem) {
		numElem = numElem ;
		randomData = new Random();
		allDominos = new ArrayList<DominoItem>();
	}
	
	private DominoItem getItemDominus() {
		 
		Integer left = randomData.nextInt(max_val);
		Integer right = randomData.nextInt(max_val);
		
		return new DominoItem(left, right);
	}
	
	public List<DominoItem> generateDominoItem(){
		
		while(!(allDominos.size() <= numElem)){
			DominoItem dItem = getItemDominus();
			if(!allDominos.contains(dItem)) allDominos.add(dItem);
		}
	
		//return allDominos.stream().distinct().collect(Collectors.toList());
		return allDominos;
	}
	
}
