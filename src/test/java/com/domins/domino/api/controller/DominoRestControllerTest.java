package com.domins.domino.api.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domins.domino.api.exception.DominoException;
import com.domins.domino.api.model.DominoItem;
import com.domins.domino.api.model.DominoRequest;
import com.domins.domino.api.model.DominoResponse;
import com.domins.domino.api.service.DominoService;

@ExtendWith(MockitoExtension.class)
public class DominoRestControllerTest {

private static Logger logger = LoggerFactory.getLogger(DominoRestControllerTest.class);
	
	@InjectMocks
	private DominoRestController dominoRestController = new DominoRestController();
	
	@Mock
	private DominoService dominoService;
	
	@BeforeAll
	static public void initContext() {
		logger.info("initContext: Begin");
	}
	
	@BeforeEach
	public void beforeTest() {
		logger.info("beforeTest: Begin");
	}
	
	@AfterEach
	public void afterTest() {
		logger.info("afterTest: Begin");
	}

	@Test
	void testDominoRestControllerTest() { 
	 	logger.info("DominoRestControllerTest: Begin - testDominoRestControllerTest");
	 	DominoRequest dominoRequest;
		DominoResponse expectedDominoResponse;
		DominoResponse computedDominoResponse;
		
		try {
			
			dominoRequest = getDominoRequestCaseTest();
			expectedDominoResponse = getDominoResponseCase1();
			
			assertTrue(dominoService != null);
			Mockito.when(dominoService.formChain(dominoRequest.getDominoList(), dominoRequest.getDominoItem())).thenReturn(expectedDominoResponse);
			assertTrue(dominoRestController != null);
			
			computedDominoResponse =  dominoService.formChain( dominoRequest.getDominoList(), dominoRequest.getDominoItem());
			assertTrue(expectedDominoResponse.equals(computedDominoResponse));
			
		} catch (RuntimeException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (DominoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	 
	
	private DominoRequest getDominoRequestCaseTest() {
		logger.info("DominoRestControllerTest: Begin - getDominoRequestCaseTest");
		DominoRequest dominoRequest = new DominoRequest();
		dominoRequest.setDominoItem(this.getInitialDominoItemCase1());
		dominoRequest.setDominoList(this.getDominoItemListCase1());
		return dominoRequest;
	}
	
	private List<DominoItem> getDominoItemListCase1() {
		logger.info("DominoRestControllerTest: Begin - getDominoItemListCase1");
		
		return List.of(new DominoItem(7,1), new DominoItem(1,5), new DominoItem(5,3), new DominoItem(3,2));
	}

	private DominoItem getInitialDominoItemCase1() {
		logger.info("DominoRestControllerTest: Begin - getInitialDominoItemCase1");
		DominoItem dominoItem = new DominoItem(7,1);
		return dominoItem;
	}
	
	private DominoResponse getDominoResponseCase1() {	
		return new DominoResponse();
	}
}
