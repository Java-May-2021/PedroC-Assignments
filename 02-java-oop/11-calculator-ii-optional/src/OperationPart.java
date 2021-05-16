
public class OperationPart {
	private String operation;
	private boolean isOperation;
	private double operand;
	private boolean isOperand;
	
	public String getOperation() {
		return this.operation;
	}

	public boolean getIsOperation() {
		return this.isOperation;
	}

	public double getOperand() {
		return this.operand;
	}

	public boolean getIsOperand() {
		return this.isOperand;
	}

	public OperationPart(String operation) {
		this.operation = operation;
		this.isOperation = true;
		this.isOperand = false;
	}

	public OperationPart(double operand) {
		this.operand = operand;
		this.isOperation = false;
		this.isOperand = true;
	}	
}
