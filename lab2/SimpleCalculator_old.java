import java.util.Scanner;

class SimpleCalculator {
	int number, number2;
	public String operation;

	SimpleCalculator(int number) {
		this.number = number;
	}

	void input() {
		Scanner s = new Scanner(System.in);
		this.operation = s.nextLine();
		number2 = s.nextInt();
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
		char op = this.operation.charAt(0);
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
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		SimpleCalculator mi = new SimpleCalculator(input);
		mi.performCalculation();
	}
}