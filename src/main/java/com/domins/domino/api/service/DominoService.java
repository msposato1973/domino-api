package com.domins.domino.api.service;

import java.util.List;

import com.domins.domino.api.exception.DominoException;
import com.domins.domino.api.model.DominoItem;
import com.domins.domino.api.model.DominoResponse;


public interface DominoService {

	public DominoResponse formChain(List<DominoItem> dominoes, DominoItem domino) throws DominoException;
   

}
