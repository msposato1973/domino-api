package net.smartkyc.demo.domino.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import net.smartkyc.demo.domino.exception.DominoChainNotFoundException;
import net.smartkyc.demo.domino.model.DominoItem;


public class DominoServiceTest {
	
	@Autowired
	DominoService dominoService;
	DominoItem dominoItem ;
			
	@BeforeEach
    public void setUp() {
		dominoItem = buildDominoItem();
	}
  
    @Test
	public void testFormChain() throws DominoChainNotFoundException {
		
		List<DominoItem> dominoList = buildListDominoes();
		
		//Run exception throwing operation here
		Collection<DominoItem> dominoes = dominoService.formChain(dominoList, dominoItem);
		dominoes.stream().collect(Collectors.toList()).forEach(System.out::println);
		assertEquals(6, dominoes.size());
	}
    
    @Test
    public void testFormChainCase2() throws DominoChainNotFoundException {
   		
   		List<DominoItem> dominoList = initializeDominoes();
   		
   		//Run exception throwing operation here
   		Collection<DominoItem> dominoes = dominoService.formChain(dominoList, dominoItem);
   		dominoes.stream().collect(Collectors.toList()).forEach(System.out::println);
   	}
    
    
    @Test
    public void testGetHightValue() throws DominoChainNotFoundException {
   		
   		List<DominoItem> dominoList = buildListDominoesHightValue();
   		
   		//Run exception throwing operation here
   		int dominoes = dominoService.getHightValue(dominoList);
   		System.out.println("dominoes HightValue -> " + dominoes);
   	}
    
    private List<DominoItem> initializeDominoes() {
		return List.of(new DominoItem(5, 2),
							 new DominoItem(4, 6),
							 new DominoItem(1, 5),
							 new DominoItem(6, 7),
							 new DominoItem(2, 4),
							 new DominoItem(7, 1) 
			   );

		 
	}
    
	private List<DominoItem> buildListDominoesHightValue() {
		return List.of(new DominoItem(7, 1), 
					           new DominoItem(1, 5), 
			                   new DominoItem(5, 3), 
			                   new DominoItem(3, 2)
			               
				       );
	}
	
	private List<DominoItem> buildListDominoes() {
		return List.of(new DominoItem(7, 1), 
					           new DominoItem(1, 5), 
			                   new DominoItem(5, 3), 
			                   new DominoItem(3, 2), 
			                   new DominoItem(2, 4),
			                   new DominoItem(2, 4)
				       );
	}
	
	private List<DominoItem> buildEmptyListDominoes() {
		return List.of();
	}

	
	
	private DominoItem buildDominoItem() {
		return new DominoItem(2, 4);
	}
}
