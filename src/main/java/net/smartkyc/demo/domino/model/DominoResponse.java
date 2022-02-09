package net.smartkyc.demo.domino.model;

public class DominoResponse {

	private ValidDominoChain dominoChain;

	public ValidDominoChain getDominoChain() {
		return dominoChain;
	}

	public void setDominoChain(ValidDominoChain dominoChain) {
		this.dominoChain = dominoChain;
	}

	@Override
	public String toString() {
		return "DominoResponse [dominoChain=" + dominoChain + "]";
	}
	
}
