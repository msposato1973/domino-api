<<<<<<< HEAD
package net.smartkyc.demo.domino.webservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.smartkyc.demo.domino.exception.DominoChainNotFoundException;
import net.smartkyc.demo.domino.service.DominoService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DominoWebserviceApplicationTests {

	@Autowired
	DominoService dominoService;
	
	@Test
	public void  formChain() throws DominoChainNotFoundException{
	}
	

}
=======
package net.smartkyc.demo.domino.webservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DominoWebserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}
>>>>>>> b551fef860bb9f8bea8708cdfcd3d5cff7488bbc
