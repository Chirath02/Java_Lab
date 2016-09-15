import java.util.Scanner;

class SimpleCalculator {
	int number, number2;
	char operation;
	

	SimpleCalculator() {

	}

	void input() {
		Scanner s = new Scanner(System.in);
		
	}

	void addInterger() {
		System.out.println(this.number + this.number2);
	}

	void subtractInteger() {
		System.out.println(this.number - this.number2);
	}

	void multiplyInterger() {
		System.out.println(this.number * this.number2);
	}

	void divideInterger() {
		if(this.number2 != 0)
			System.out.println(this.number / this.number2);
		else
			System.out.println("Error!! 2nd number can't be a zero");
	}

	void performCalculation() {
		input();
		char op = '+';
		switch(op) {
			case '+': {
				addInterger();
				break;
			}
			case '-': {
				subtractInteger();
				break;
			}
			case '*': {
				multiplyInterger();
				break;
			}
			case '/': {
				divideInterger();
				break;
			}
			default: 
				System.out.println("Invalid Operation");
		}
	}

	public static void main(String[] args) {
		SimpleCalculator mi = new SimpleCalculator();
		
	}
}