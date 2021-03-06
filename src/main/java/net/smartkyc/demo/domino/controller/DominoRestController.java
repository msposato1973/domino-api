package net.smartkyc.demo.domino.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.smartkyc.demo.domino.exception.DominoChainNotFoundException;
import net.smartkyc.demo.domino.model.DominoItem;
import net.smartkyc.demo.domino.model.DominoRequest;
import net.smartkyc.demo.domino.model.DominoResponse;
import net.smartkyc.demo.domino.service.DominoService;

@RestController
@RequestMapping("/dominos")
public class DominoRestController {
	private static final Logger log = LoggerFactory.getLogger(DominoRestController.class);
	
	@Autowired
	private DominoService dominoService;
	
	@PostMapping("/formChain")
	public DominoResponse formChain(@RequestBody DominoRequest request) throws DominoChainNotFoundException  {
		log.info("Into saveDepartment");
		
		return getDominoHighestValue(request);
	}
	 
	private  DominoResponse createDominoResponse(List<DominoItem> dominoListChain) throws DominoChainNotFoundException {
		DominoResponse response = new  DominoResponse();
		int total = dominoService.getHightValue(dominoListChain);
		response.setDominoListChain(dominoListChain);
		response.setTotal(total);
		
		return response;
	}
	
	DominoResponse getDominoHighestValue(final DominoRequest dominoRequest) throws DominoChainNotFoundException {
		log.info("getDominoHighestValue: Begin");
		DominoItem dominoItem = dominoRequest.getDominoItem();
		List<DominoItem> dominoList = dominoRequest.getDominoList();
		DominoResponse dominoResponse = null;
		
		try {	 
		
			log.info("dominoRequest = " + dominoRequest);
			List<DominoItem> dominoListChain = dominoService.formChain(dominoList, dominoItem);
			dominoResponse = createDominoResponse(dominoListChain) ;
			
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (DominoChainNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		return dominoResponse;
	}
	
	
}
