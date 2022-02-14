package com.domins.domino.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.domins.domino.api.exception.DominoException;
import com.domins.domino.api.model.DominoItem;
import com.domins.domino.api.model.DominoResponse;

@Service
public class DominoServiceImpl implements DominoService{

	private static final Logger log =  LoggerFactory.getLogger(DominoServiceImpl.class);
	
	@Override
	public DominoResponse formChain(List<DominoItem> dominoes, DominoItem domino) throws DominoException{
		
		// TODO Auto-generated method stub
		log.info("Into formChain - DominoService");
		
		List<DominoItem> chainDominoes = new ArrayList<>();
		chainDominoes.add(domino);
		
	    for (int i = 0; i < dominoes.size(); i++) {
	    	DominoItem tempValues = chainDominoes.get(chainDominoes.size()-1); 
			formChain(dominoes, tempValues, chainDominoes);
		}
		 
	    log.info("Into formChain - DominoService");
	    return createDominoResponse(chainDominoes);
	}
	
	private void formChain(List<DominoItem> dominoes, DominoItem tempValues, List<DominoItem> chainDominoes) throws DominoException{
		// TODO Auto-generated method stub
		log.info("Into formChain - DominoService");
		for (int j = 0; j < dominoes.size(); j++) {
	    	  DominoItem temp2Values = dominoes.get(j);

	          if (validationPosition(tempValues.getRight() , temp2Values.getLeft())) {
	        	  if(!isInChain(chainDominoes, temp2Values)) {
	        		  chainDominoes.add(temp2Values);
	        	  }
	          }
	    }
	    
	    
	}
	
	 
	private  DominoResponse createDominoResponse(List<DominoItem> dominoListChain) throws DominoException {
		log.info("Into createDominoResponse - DominoService");
		DominoResponse response = new DominoResponse();
		int total = getHighValue(dominoListChain);
		response.setDominoListChain(dominoListChain);
		response.setTotal(total);
		
		return response;
	}
	
	
	private int getHighValue(List<DominoItem> chainDominoes) throws DominoException {
		// TODO Auto-generated method stub
		log.info("Into getHightValue - DominoService");
		
		
		/* 7. The value of a chain is computed by summing the common values between
	       connected pieces. I.e.: (7, 1) - (1, 5) - (5, 3) - (3, 2) has a value of 1 + 5 + 3 = 9;
	    */
		 
		
		int value = 0;
		for (int index  = 0; index  < chainDominoes.size()-1; index ++) 
			value += chainDominoes.get(index).getRight();
		
		log.info("Into getHightValue - DominoService getHighValue : " + value);
		return value;
	}
	
	
	
	
	private boolean validationPosition(int a , int b) {
		return  (a == b);
	}
	
	private boolean isInChain(List<DominoItem> chainDominoes, DominoItem domino) {
		
		log.info("Into isInChain - DominoService");
		DominoItem tempValues = chainDominoes.stream()                        
	                .filter(x -> (x.getLeft() == domino.getLeft() && x.getRight() == domino.getRight()))         
	                .findAny()                                       
	                .orElse(null); 
		
		 return (tempValues!=null)? true: false;
	} 

}
