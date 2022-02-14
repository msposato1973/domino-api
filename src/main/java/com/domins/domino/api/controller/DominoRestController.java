package com.domins.domino.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domins.domino.api.exception.DominoException;
import com.domins.domino.api.model.DominoItem;
import com.domins.domino.api.model.DominoRequest;
import com.domins.domino.api.model.DominoResponse;
import com.domins.domino.api.service.DominoService;

@RestController
@RequestMapping("/dominos")
public class DominoRestController {
	private static final Logger log = LoggerFactory.getLogger(DominoRestController.class);
	
	@Autowired
	private DominoService dominoService;
	
	@PostMapping("/formChain")
	public DominoResponse formChain(@RequestBody DominoRequest request) throws DominoException  {
		log.info("Into saveDepartment");
		return getDominoHighestValue(request);
	}
	
	DominoResponse getDominoHighestValue(final DominoRequest dominoRequest) throws DominoException {
		log.info("getDominoHighestValue: Begin");
		DominoItem dominoItem = dominoRequest.getDominoItem();
		List<DominoItem> dominoList = dominoRequest.getDominoList();
		DominoResponse dominoResponse = null;
		 
		if(dominoItem.getLeft() == (dominoItem.getRight())){
				throw new DominoException("Left and Right cannot be equals");
		}
		 
		try {	 
		
			log.info("dominoRequest = " + dominoRequest);
			dominoResponse = dominoService.formChain(dominoList, dominoItem);
			log.info("dominoResponse = " + dominoResponse);
			
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (DominoException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new DominoException(e); 
		}
		
		return dominoResponse;
	}
	
	
	
	
}
