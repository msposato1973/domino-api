package net.smartkyc.demo.domino.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.smartkyc.demo.domino.exception.DominoChainNotFoundException;
import net.smartkyc.demo.domino.model.DominoItem;

@Service
public class DominoService {

	private static final Logger log =  LoggerFactory.getLogger(DominoService.class);
	 
	public List<DominoItem> formChain(final List<DominoItem> dominoes, final DominoItem domino) throws DominoChainNotFoundException{
		// TODO Auto-generated method stub
		log.info("Into formChain - DominoService");
		List<DominoItem> chainDominoes = new ArrayList<>();
		chainDominoes.add(domino);
		
	    for (int i = 0; i < dominoes.size(); i++) {
	    	DominoItem tempValues = chainDominoes.get(chainDominoes.size()-1); 
			formChain(dominoes, tempValues, chainDominoes);
		}
		 
	    return chainDominoes;
	}
	
	
	
	
	public int getHightValue(List<DominoItem> chainDominoes) {
		log.info("Into getHightValue - DominoService");
		// Firt Option 
		Set<Integer> setInt = new HashSet<>();
		
		/*
		chainDominoes.forEach((domino) -> {
			 DominoItem tempValues = chainDominoes.stream().filter(x -> (x.getRight() == domino.getLeft()))
	    			  .findFirst()                                       
		                .orElse(null);
			 
			 if(tempValues!=null)setInt.add(tempValues.getLeft());
		});
		*/
		
		// Second Option 
		for (int j = 0; j < chainDominoes.size()-1; j++) {
	    	  DominoItem domino = chainDominoes.get(j);

	    	  DominoItem tempValues = chainDominoes.stream().filter(x -> (x.getRight() == domino.getLeft()))
	    			  .findFirst()                                       
		                .orElse(null);
	    	  if(tempValues!=null) setInt.add(tempValues.getLeft());
	    }
		
		return setInt.stream().collect(Collectors.summingInt(Integer::intValue));
	}
}
