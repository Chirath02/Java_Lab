import java.util.Scanner;

class PrintMultiplicationTable {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=0; i<=20;++i)
			System.out.println(i + " x " + n + " = " + i*n); 
	}
}