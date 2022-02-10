package net.smartkyc.demo.domino.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.smartkyc.demo.domino.model.DominoItem;
import net.smartkyc.demo.domino.model.DominoResponse;
import net.smartkyc.demo.domino.model.ValidDominoChain;
import net.smartkyc.demo.domino.model.exception.DominoException;
import net.smartkyc.demo.domino.service.types.DominoService;

@Component
public class DominoServer implements DominoService {
	
	private static final Logger log = LoggerFactory.getLogger(DominoServer.class);

	// Valid domino chain with highest value
	private static ValidDominoChain maxValueChain = new ValidDominoChain();

	// Init domino map
	// To each value from 1 to 10 is associated a set of domino items 
	// Each item in the set contains the associated value either as first or second element
	public static Map<Integer, Set<DominoItem>> dominoMap = 
			new HashMap<Integer, Set<DominoItem>>();
		
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
		dominoMap.put(new Integer(1), one);
		dominoMap.put(new Integer(2), two);
		dominoMap.put(new Integer(3), three);
		dominoMap.put(new Integer(4), four);
		dominoMap.put(new Integer(5), five);
		dominoMap.put(new Integer(6), six);
		dominoMap.put(new Integer(7), seven);
		dominoMap.put(new Integer(8), eight);
		dominoMap.put(new Integer(9), nine);
		dominoMap.put(new Integer(10), ten);	
	}
	
	public DominoResponse getHighestValueDominoChain(
			DominoItem initialDominoItem, 
			List<DominoItem> dominoItemList)
			throws DominoException {
		// Domino response
		DominoResponse dominoResponse = null;
		
		// Current valid domino chain will contains all possible valid domino chains 
		// generated from initialDominoItem and dominoItemList
		ValidDominoChain currentValidChain;
		
		try {
			// Init response
			dominoResponse = new DominoResponse();
			
			// Load domino items to domino map, without considering the initial domino item
			dominoItemList.forEach(item -> {
				if (!item.equals(initialDominoItem)) {
					dominoMap.get(item.getFirst()).add(item);
					dominoMap.get(item.getSecond()).add(item);
				}
			});
			// Init valid domino chain with highest value	
			maxValueChain.setChain(new LinkedList<DominoItem>());
			maxValueChain.getChain().add(initialDominoItem);
			maxValueChain.setLeftMost(initialDominoItem.getFirst());
			maxValueChain.setRightMost(initialDominoItem.getSecond());
			maxValueChain.setValue(new Integer(0));
			// Init current valid domino chain
			currentValidChain = new ValidDominoChain();
			currentValidChain.setChain(new LinkedList<DominoItem>());
			currentValidChain.getChain().add(initialDominoItem);
			currentValidChain.setLeftMost(initialDominoItem.getFirst());
			currentValidChain.setRightMost(initialDominoItem.getSecond());
			currentValidChain.setValue(new Integer(0)); 
			
			// Calculate valid domino chain with highest value recursively
			calculateHighestValueChain(currentValidChain);
			
			// Set domino response
			dominoResponse.setDominoChain(maxValueChain);
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			throw new DominoException(e.getMessage());
		}
		return dominoResponse;
	}

	private void calculateHighestValueChain(
			ValidDominoChain currentValidChain) {
		// Mark end of the chain right side
		boolean endChainRight;
		// Mark end of the chain left side
		boolean endChainLeft;
		try {		
			// Update current valid chain right side
			endChainRight = updateRightChain(currentValidChain);
					
			// Update current valid chain left side
			endChainLeft = updateLeftChain(currentValidChain);
			
			// Check if no more items can be added, neither to the right side nor to the left side
			if (endChainRight && endChainLeft) {
				// If no more items can be added
				// Update maxValueChain if current valid chain has a higher value
				if (currentValidChain.getValue() > maxValueChain.getValue()) {
					LinkedList<DominoItem> newLinkedList = 
							(LinkedList<DominoItem>) currentValidChain.getChain().clone();
					maxValueChain.setChain(newLinkedList);
					maxValueChain.setValue(currentValidChain.getValue());
					maxValueChain.setLeftMost(currentValidChain.getLeftMost());
					maxValueChain.setRightMost(currentValidChain.getRightMost());
				}
			}			
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	private Boolean updateLeftChain(ValidDominoChain currentValidChain) {
		// endChain marks the left end of the current valid chain
		// True if and only if no more items can be added to the left
		Boolean endChain[] = new Boolean[1];
		endChain[0] = true;
		DominoItem item;
		try {
			// Consider domino items associated to current valid chain left most value
			Set<DominoItem> leftMostSet = dominoMap.get(currentValidChain.getLeftMost());
			Iterator<DominoItem> iterator = leftMostSet.iterator();
			while (iterator.hasNext()) {
				// Get next item
				item = iterator.next();
				
				// If item is not visited
				if (!item.getVisited()) {
					// Mark the left end of the current chain as false
					endChain[0] = false;
					
					// Mark item as visited
					item.setVisited(true);

					// Update current valid chain by adding current item to the left
					Integer leftMost = currentValidChain.getLeftMost();
					currentValidChain.getChain().addFirst(item);
					Integer newLeftMostValue = 
							(item.getFirst().equals(leftMost)) ? 
									item.getSecond() : item.getFirst();
					currentValidChain.setRightMost(newLeftMostValue);			
					currentValidChain.setValue(currentValidChain.getValue() + 
							leftMost);
					
					// Recursive call with updated current valid chain
					calculateHighestValueChain(currentValidChain);
					
					// Mark item as not visited
					item.setVisited(false);
					
					// Update back current valid chain by removing current item from the left
					currentValidChain.getChain().removeFirst();
					currentValidChain.setValue(leftMost);
					currentValidChain.setValue(currentValidChain.getValue() - leftMost);
				}
			}
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			throw e;
		}
		return endChain[0];
 	}

	private Boolean updateRightChain(ValidDominoChain currentValidChain) {
		// endChain marks the right end of the current valid chain
		// True if and only if no more items can be added to the right
		Boolean endChain[] = new Boolean[1];
		endChain[0] = true;
		DominoItem item;
		try {
			// Consider domino items associated to current valid chain right most value
			Set<DominoItem> rightMostSet = dominoMap.get(currentValidChain.getRightMost());
			Iterator<DominoItem> iterator = rightMostSet.iterator();
			while (iterator.hasNext()) {
				// Get next item
				item = iterator.next();
				
				// If item is not visited
				if (!item.getVisited()) {
					// Mark the right end of the current chain as false
					endChain[0] = false;
					
					// Mark item as visited
					item.setVisited(true);
					
					// Update current valid chain by adding current item to the right
					Integer rightMost = currentValidChain.getRightMost();
					currentValidChain.getChain().addLast(item);
					Integer newRightMostValue = 
							(item.getFirst().equals(rightMost)) ? 
									item.getSecond() : item.getFirst();
					currentValidChain.setRightMost(newRightMostValue);
					currentValidChain.setValue(currentValidChain.getValue() + 
							rightMost);
					
					// Recursive call with updated current valid chain
					calculateHighestValueChain(currentValidChain);
					
					// Mark item as not visited
					item.setVisited(false);
					
					// Update back current valid chain by removing current item from the right
					currentValidChain.getChain().removeLast();
					currentValidChain.setRightMost(rightMost);
					currentValidChain.setValue(currentValidChain.getValue() - rightMost);
				}
			}
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return endChain[0];
	}

}
