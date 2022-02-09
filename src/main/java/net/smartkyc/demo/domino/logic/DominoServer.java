package net.smartkyc.demo.domino.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.smartkyc.demo.domino.model.DominoItem;
import net.smartkyc.demo.domino.model.DominoResponse;
import net.smartkyc.demo.domino.model.ValidDominoChain;
import net.smartkyc.demo.domino.service.DominoException;

public class DominoServer {
	
	private static final Logger log = LoggerFactory.getLogger(DominoServer.class);

	public static Map<Integer, Set<DominoItem>> map = 
			new HashMap<Integer, Set<DominoItem>>();
	
	private static ValidDominoChain maxValueChain = new ValidDominoChain();
	
	static {
		Set<DominoItem> one = new HashSet<DominoItem>();
		Set<DominoItem> two = new HashSet<DominoItem>();
		Set<DominoItem> three = new HashSet<DominoItem>();	
		Set<DominoItem> four = new HashSet<DominoItem>();
		Set<DominoItem> five = new HashSet<DominoItem>();
		Set<DominoItem> six = new HashSet<DominoItem>();
		Set<DominoItem> seven = new HashSet<DominoItem>();
		Set<DominoItem> eight = new HashSet<DominoItem>();
		Set<DominoItem> nine = new HashSet<DominoItem>();
		Set<DominoItem> ten = new HashSet<DominoItem>();
		map.put(new Integer(1), one);
		map.put(new Integer(2), two);
		map.put(new Integer(3), three);
		map.put(new Integer(4), four);
		map.put(new Integer(5), five);
		map.put(new Integer(6), six);
		map.put(new Integer(7), seven);
		map.put(new Integer(8), eight);
		map.put(new Integer(9), nine);
		map.put(new Integer(10), ten);	
	}
	
	public DominoResponse getHighestValueDominoChain(
			DominoItem initialDominoItem, 
			List<DominoItem> dominoItemList)
			throws DominoException {
		DominoResponse dominoResponse = null;
		ValidDominoChain currentChain;
		
		try {
			// Init response
			dominoResponse = new DominoResponse();
			// Init domino map
			dominoItemList.forEach(item -> {
				if (!item.equals(initialDominoItem)) {
					map.get(item.getFirst()).add(item);
				}
				if (!item.equals(initialDominoItem)) {
					map.get(item.getSecond()).add(item);
				}
			});
			// Init max value chain	
			maxValueChain.setChain(new LinkedList<DominoItem>());
			maxValueChain.getChain().add(initialDominoItem);
			maxValueChain.setLeftMost(initialDominoItem.getFirst());
			maxValueChain.setRightMost(initialDominoItem.getSecond());
			maxValueChain.setValue(new Integer(0));
			// Init current chain
			currentChain = new ValidDominoChain();
			currentChain.setChain(new LinkedList<DominoItem>());
			currentChain.getChain().add(initialDominoItem);
			currentChain.setLeftMost(initialDominoItem.getFirst());
			currentChain.setRightMost(initialDominoItem.getSecond());
			currentChain.setValue(new Integer(0)); 
			
			calculateHighestValueChain(currentChain);
			
			dominoResponse.setDominoChain(maxValueChain);
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			throw new DominoException(e.getMessage());
		}
		return dominoResponse;
	}

	private void calculateHighestValueChain(
			ValidDominoChain currentChain) {
		boolean endChainRight;
		boolean endChainLeft;
		try {
			
			// Update right chain
			endChainRight = updateRightChain(currentChain);
					
			// Update left chain
			endChainLeft = updateLeftChain(currentChain);
				
			if (endChainRight && endChainLeft) {
				if (currentChain.getValue() > maxValueChain.getValue()) {
					LinkedList<DominoItem> newLinkedList = 
							(LinkedList<DominoItem>) currentChain.getChain().clone();
					maxValueChain.setChain(newLinkedList);
					maxValueChain.setValue(currentChain.getValue());
					maxValueChain.setLeftMost(currentChain.getLeftMost());
					maxValueChain.setRightMost(currentChain.getRightMost());
				}
			}			
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	private Boolean updateLeftChain(ValidDominoChain currentChain) {
		Boolean endChain[] = new Boolean[1];
		endChain[0] = true;
		try {
			map.get(currentChain.getLeftMost()).forEach(item -> {
				if (!item.isVisited()) {
					endChain[0] = false;
					Integer leftMost = currentChain.getLeftMost();
					// Update current chain
					currentChain.getChain().addFirst(item);
					item.setVisited(true);
					Integer newLeftMostValue = 
							(item.getFirst().equals(leftMost)) ? 
									item.getSecond() : item.getFirst();
					currentChain.setRightMost(newLeftMostValue);
					
					currentChain.setValue(currentChain.getValue() + 
							leftMost);
					// Recursive call
					calculateHighestValueChain(currentChain);
					// Update back current back
					currentChain.getChain().removeFirst();
					currentChain.setValue(leftMost);
					item.setVisited(false);
				}
			});
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			throw e;
		}
		return endChain[0];
 	}

	private Boolean updateRightChain(ValidDominoChain currentChain) {
		Boolean endChain[] = new Boolean[1];
		endChain[0] = true;
		try {
			map.get(currentChain.getRightMost()).forEach(item -> {
				if (!item.isVisited()) {
					endChain[0] = false;
					Integer rightMost = currentChain.getRightMost();
					// Update current chain
					currentChain.getChain().addLast(item);
					item.setVisited(true);
					
					Integer newRightMostValue = 
							(item.getFirst().equals(rightMost)) ? 
									item.getSecond() : item.getFirst();
					currentChain.setRightMost(newRightMostValue);
					
					currentChain.setValue(currentChain.getValue() + 
							rightMost);
					// Recursive call
					calculateHighestValueChain(currentChain);
					// Update back current back
					currentChain.getChain().removeLast();
					currentChain.setValue(rightMost);
					item.setVisited(false);
				}
			});
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			throw e;
		}
		return endChain[0];
	}

}
