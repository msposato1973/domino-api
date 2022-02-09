package net.smartkyc.demo.domino.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.smartkyc.demo.domino.service.DominoService;
import net.smartkyc.demo.domino.webservice.DominoWebserviceApplication;

@RestController
@RequestMapping("/api")
public class DominoRestController {
	private static final Logger log = LoggerFactory.getLogger(DominoRestController.class);
	
	@Autowired
	private DominoService dominoService;
	
	
}
