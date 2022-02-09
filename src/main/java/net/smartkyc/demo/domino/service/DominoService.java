package net.smartkyc.demo.domino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.smartkyc.demo.domino.model.DominoItem;
import net.smartkyc.demo.domino.model.DominoResponse;

@Service
public interface DominoService {
	
	public DominoResponse getHighestValueDominoChain(
			DominoItem initialDominoItem,
			List<DominoItem> dominoItemList
			) throws DominoException;
	
}

