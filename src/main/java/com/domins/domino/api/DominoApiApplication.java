package com.domins.domino.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DominoApiApplication {

 
	private static final Logger log = LoggerFactory.getLogger(DominoApiApplication.class);
	
	public static void main(String[] args) {
		log.info("main: Begin");
		SpringApplication.run(DominoApiApplication.class, args);
	}

}
