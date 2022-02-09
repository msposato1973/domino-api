package net.smartkyc.demo.domino.logic;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.smartkyc.demo.domino.model.DominoItem;
import net.smartkyc.demo.domino.model.DominoResponse;
import net.smartkyc.demo.domino.service.DominoException;


public class DominoServerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DominoServerTest.class);
			
	@Test
	public void testCase1() {
		logger.info("testCase1");
		DominoServer server = null;
		DominoItem initialDominoItem = null;
		List<DominoItem> dominoItemList = null;
		DominoResponse dominoResponse = null;
		try {
			server = new DominoServer();
			initialDominoItem = getInitialDominoItemCase1();
			dominoItemList = getDominoItemListCase1();
			dominoResponse = server.getHighestValueDominoChain(
					initialDominoItem,
					dominoItemList);
			assertTrue(dominoResponse != null);
			logger.info("dominoResponse = " + dominoResponse);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		} catch (DominoException e) {
			fail(e.getMessage());
		}
	}

	
	private List<DominoItem> getDominoItemListCase1() {
		List<DominoItem> dominoItemList = new ArrayList<DominoItem>();

		dominoItemList.add(new DominoItem(7,1));
		dominoItemList.add(new DominoItem(1,5));
		dominoItemList.add(new DominoItem(5,3));
		dominoItemList.add(new DominoItem(3,2));

		return dominoItemList;
	}

	private DominoItem getInitialDominoItemCase1() {
		DominoItem dominoItem = new DominoItem(7,1);
		return dominoItem;
	}
}

