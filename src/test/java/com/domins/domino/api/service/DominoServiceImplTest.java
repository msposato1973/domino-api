package com.domins.domino.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.domins.domino.api.DominoApiApplication;
import com.domins.domino.api.exception.DominoException;
import com.domins.domino.api.model.DominoItem;
import com.domins.domino.api.model.DominoResponse;

class DominoServiceImplTest {

	private static final Logger log = LoggerFactory.getLogger(DominoServiceImplTest.class);

	private DominoService dominoService;
	private DominoItem dominoItem;
	private static DominoApiApplication application;
	private static ApplicationContext context;

	@BeforeAll
	private static void init() {
		context = new AnnotationConfigApplicationContext(DominoApiApplication.class);
	}

	@BeforeEach
	void setUp() throws Exception {
		log.info("Into begin");
		dominoService = context.getBean(DominoService.class);
	}

	@Test
	void testDominoService() {
		log.info("Into test");
		dominoService = context.getBean(DominoService.class);
		log.info("dominoService=" + dominoService);

	}

	@Test
	public void testFormChain() throws DominoException {
		log.info("Into testFormChain");
		List<DominoItem> dominoList = buildListDominoes();
		dominoItem = buildDominoItem();

		// Run exception throwing operation here
		DominoResponse response = dominoService.formChain(dominoList, dominoItem);
		response.getDominoListChain().stream().collect(Collectors.toList()).forEach(System.out::println);

		assertEquals(1, response.getDominoListChain().size());
		log.info("dominoService.formChain(...) : " + response.getDominoListChain().size());
		log.info("END testFormChain ");
	}

	@Test
	public void testFormChainCase2() throws DominoException {
		log.info("Into testFormChainCase2");
		List<DominoItem> dominoList = initializeDominoes();
		dominoItem = buildDominoItem();
		// Run exception throwing operation here
		DominoResponse response  = dominoService.formChain(dominoList, dominoItem);
		response.getDominoListChain().stream().collect(Collectors.toList()).forEach(System.out::println);
		
		log.info("END testFormChainCase2 ");
	}
	
	@Test
    public void testGetHightValue() throws DominoException {
		log.info("Into testGetHightValue");
   		List<DominoItem> dominoList = buildListDominoesHightValue();
   		dominoItem = buildDominoItem();
   		
   		//Run exception throwing operation here
   		DominoResponse response  = dominoService.formChain(dominoList, dominoItem);
   		
   		int totalValue = response.getTotal();
   		System.out.println("dominoes HightValue -> " + totalValue);
   		log.info("END testGetHightValue ");
   	}
	
	@Test
    public void testEmptyListDominoes() throws DominoException {
		log.info("Into testGetHightValue");
   		List<DominoItem> dominoList = buildEmptyListDominoes();
   		dominoItem = buildDominoItem();
   		
   		//Run exception throwing operation here
   		DominoResponse response  = dominoService.formChain(dominoList, dominoItem);
   		
   		int totalValue = response.getTotal();
   		assertEquals(1, response.getDominoListChain().size());
   		assertEquals(0, totalValue);
   		
   		System.out.println("dominoes ListChain size -> " + response.getDominoListChain().size());
   		System.out.println("dominoes HightValue -> " + totalValue);
   		log.info("END testEmptyListDominoes ");
   	}
	
	@Test
	public void testLeftRightEquals() throws DominoException {
		log.info("Into testFormChainCase2");
		 
	 	// Run exception throwing operation here
		try {
			DominoResponse response  = dominoService.formChain(initializeDominoes(), new DominoItem(4, 4));
		
		} catch (DominoException ex) {
			assertEquals("Left and Right cannot be equals", ex.getMessage());
		}
	 	
		log.info("END testFormChainCase2 ");
	}

	private List<DominoItem> initializeDominoes() {
		log.info("Into initializeDominoes");
		return List.of(new DominoItem(5, 2), new DominoItem(4, 6), new DominoItem(1, 5), new DominoItem(6, 7),
				new DominoItem(2, 4), new DominoItem(7, 1));

	}

	private List<DominoItem> buildListDominoesHightValue() {
		log.info("Into buildListDominoesHightValue");
		return List.of(new DominoItem(7, 1), new DominoItem(1, 5), new DominoItem(5, 3), new DominoItem(3, 2));
	}

	private List<DominoItem> buildListDominoes() {
		log.info("Into buildListDominoes");
		return List.of(new DominoItem(7, 1), new DominoItem(1, 5), new DominoItem(5, 3), new DominoItem(3, 2),
				new DominoItem(2, 4), new DominoItem(2, 4));
	}

	private List<DominoItem> buildEmptyListDominoes() {
		log.info("Into buildEmptyListDominoes");
		return List.of();
	}

	private DominoItem buildDominoItem() {
		log.info("Into buildDominoItem");
		return new DominoItem(2, 4);
	}
	
	private List<DominoItem> getDominoItemListCase1() {
		log.info("Into getDominoItemListCase1");
		return List.of( new DominoItem(7,1) , new DominoItem(1,5) , new DominoItem(5,3), new DominoItem(3,2));
	}
  
}
