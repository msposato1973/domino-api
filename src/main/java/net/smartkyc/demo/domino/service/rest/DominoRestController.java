package net.smartkyc.demo.domino.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.smartkyc.demo.domino.DominoWebserviceApplication;
import net.smartkyc.demo.domino.model.DominoRequest;
import net.smartkyc.demo.domino.model.DominoResponse;
import net.smartkyc.demo.domino.model.exception.DominoException;
import net.smartkyc.demo.domino.service.types.DominoService;

@RestController
@RequestMapping("/api")
public class DominoRestController {
	private static final Logger log = LoggerFactory.getLogger(DominoRestController.class);
	
	@Autowired
	private DominoService dominoService;
	
	@GetMapping("/dominoHighestValue")
	public DominoResponse getDominoHighestValue(
			@RequestBody DominoRequest dominoRequest
			) {
		log.info("getDominoHighestValue: Begin");
		DominoResponse dominoResponse = null;
		try {
			log.info("dominoRequest = " + dominoRequest);
			dominoResponse = dominoService.getHighestValueDominoChain(
					dominoRequest.getInitialDominoItem(), 
					dominoRequest.getDominoItems());
			log.info("dominoResponse = " + dominoResponse);
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (DominoException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return dominoResponse;
	}
}
