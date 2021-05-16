import java.util.ArrayList;

public class Calculator {
	private ArrayList<OperationPart> parts = new ArrayList<OperationPart>();
	
	public void performOperation(String operation) {
		parts.add(new OperationPart(operation));
	}

	public void performOperation(double operand) {
		parts.add(new OperationPart(operand));
	}
	
	public double getResults() {
		// this.printParts();

		// First, Execute Multiplications and Divisions
		int numberOfParts = this.parts.size();
		for (int i = 0; i < numberOfParts; i++) {
			if (this.parts.get(i).getIsOperation()) {
				if (this.parts.get(i).getOperation().equals("*")) {
					double total = this.parts.get(i-1).getOperand() * this.parts.get(i+1).getOperand();
					this.parts.set(i-1, new OperationPart(total));
					this.parts.remove(i+1);
					this.parts.remove(i);
					numberOfParts = numberOfParts - 2;
				} else if (this.parts.get(i).getOperation().equals("/")) {
					double total = this.parts.get(i-1).getOperand() / this.parts.get(i+1).getOperand();
					this.parts.set(i-1, new OperationPart(total));
					this.parts.remove(i+1);
					this.parts.remove(i);
					numberOfParts = numberOfParts - 2;
				}		
			}
		}
		// this.printParts();
		
		// Second, Execute Additions and Subtractions
		numberOfParts = this.parts.size();
		for (int i = 0; i < numberOfParts; i++) {
			if (this.parts.get(i).getIsOperation()) {
				if (this.parts.get(i).getOperation().equals("+")) {
					double total = this.parts.get(i-1).getOperand() + this.parts.get(i+1).getOperand();
					this.parts.set(i-1, new OperationPart(total));
					this.parts.remove(i+1);
					this.parts.remove(i);
					numberOfParts = numberOfParts - 2;
					i--;
				} else if (this.parts.get(i).getOperation().equals("-")) {
					double total = this.parts.get(i-1).getOperand() - this.parts.get(i+1).getOperand();
					this.parts.set(i-1, new OperationPart(total));
					this.parts.remove(i+1);
					this.parts.remove(i);
					numberOfParts = numberOfParts - 2;
					i--;
				}		
			}
		}
		// this.printParts();

		// Finally, return total
		return this.parts.get(0).getOperand();
	}
	
	private void printParts() {
		System.out.print("[ ");
		for (int i = 0; i < this.parts.size(); i++) {
			if (this.parts.get(i).getIsOperation()) {
				System.out.print(this.parts.get(i).getOperation());
			} else if (this.parts.get(i).getIsOperand()) {
				System.out.print(this.parts.get(i).getOperand());
			}
			if ((i+1) != this.parts.size()) {
				System.out.print(" ");
			}
		}
		System.out.println(" ]");
	}
}
