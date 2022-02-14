package net.smartkyc.demo.domino;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DominoWebserviceApplication {

	private static final Logger log = LoggerFactory.getLogger(DominoWebserviceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DominoWebserviceApplication.class, args);
	}

}
