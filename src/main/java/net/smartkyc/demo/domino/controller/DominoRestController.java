package net.smartkyc.demo.domino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.smartkyc.demo.domino.service.DominoService;

@RestController
@RequestMapping("/api")
public class DominoRestController {
	
	@Autowired
	private DominoService dominoService;
}
