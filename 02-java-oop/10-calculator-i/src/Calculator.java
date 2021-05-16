
public class Calculator {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double results;
	
	public Calculator() {}

	public void setOperandOne(double operand) {
		this.operandOne = operand;
	}

	public void setOperandTwo(double operand) {
		this.operandTwo = operand;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void performOperation() {
		if (this.operation.equals("+")) {
			this.results = this.operandOne + this.operandTwo;
		} else if (this.operation.equals("-")) {
			this.results = this.operandOne - this.operandTwo;
		}
	}

	public double getResults() {
		return this.results;
	}
	 
}
