package net.smartkyc.demo.domino.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.smartkyc.demo.domino.model.DominoItem;

@Service
public class DominoService {

private List<DominoItem> allRecord = new ArrayList<DominoItem>();
	
	public List<DominoItem> getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(List<DominoItem> allRecord) {
		this.allRecord = allRecord;
	}
}
