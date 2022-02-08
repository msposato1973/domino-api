package net.smartkyc.demo.domino.exception;

public class DominoChainNotFoundException extends Exception {
	 
	// Parameterless Constructor
	public DominoChainNotFoundException() {
	}

	// Constructor that accepts a errorMessage
	public DominoChainNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	// Constructor that accepts a errorMessage
	public DominoChainNotFoundException(Throwable cause) {
		super(cause);
	}

	// Constructor that accepts a errorMessage and cause
	public DominoChainNotFoundException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

}
