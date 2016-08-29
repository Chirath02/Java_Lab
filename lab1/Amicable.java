import java.util.Scanner;

class Amicable {
	public static int getSumofDivisors(int num) {
		int temp = 0;
		for(int i=1;i<=num/2;++i)
			if(num%i == 0)
				temp += i;
		return temp;
	}
	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int num = s.nextInt();
			int num2 = s.nextInt();

			if(num2 == getSumofDivisors(num) && num == getSumofDivisors(num2)) 
				System.out.println(num +  " and " + num2 + " are amicable numbers.");
			else 
				System.out.println(num +  " and " + num2 + " are not amicable numbers.");

	}
}