package seis610.gp.main.exception;

import seis610.gp.model.Solution;

public class SoulutionFoundException extends Exception {

	private static final long serialVersionUID = 4758062562441181848L;
	public Solution solution;

	public SoulutionFoundException(Solution solution) {
		this.solution = solution;
	}
	public Solution getSolution() {
		return this.solution;
	}
	
	
	
	
	
	
}
