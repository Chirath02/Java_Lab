import java.util.Scanner;

class Emirp {
	public static boolean isPrime(int num) {
		int flag = 1;
		for(int i=2; i<=num/2;++i) {
			if(num%i == 0)
				flag = 0;
		}
		if(flag==0)
			return false;
		return true;
	}
	public static int reverseInt(int num) {
		int temp = 0;
		while(num>0) {
			temp = (temp*10) + (num%10);
			num = num / 10;
		}
		return temp;
	}
	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int num = s.nextInt();
			int rev = reverseInt(num);
			if(!isPrime(num)) 
				System.out.println("Error input is not a prime");
			else 
				if(isPrime(num)!=isPrime(rev)) 
					System.out.println("Emirp");
				else 
					System.out.println("Not Emirp");

	}
}