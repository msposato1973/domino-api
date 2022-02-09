package net.smartkyc.demo.domino.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.smartkyc.demo.domino.model.DominoItem;

@Service
public class DominoService {

	private static final Logger log = LoggerFactory.getLogger(DominoService.class);
	
	private Map<Integer, List<DominoItem>> mapRecord = new  HashMap<>();
	private List<DominoItem> allRecord = new ArrayList<DominoItem>();
	
	public List<DominoItem> getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(List<DominoItem> allRecord) {
		this.allRecord = allRecord;
	}
	
	
}
