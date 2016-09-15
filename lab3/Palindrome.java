import java.util.Scanner;
class Palindrome {
	void checkForPalindrome(String str) {
		/*
		int i=0, flag = 1, length = str.length();
		while(i++ < length/2) 
			if(str.charAt(i) != str.charAt(length-i-1))
				flag = 0;
		if(flag == 1) 
			System.out.println("It is a Palindrome");
		else 
			System.out.println("It is not a Palindrome");
		*/
	 	StringBuffer stringbuf = new StringBuffer(str);
		if(str.compareTo(stringbuf.reverse().toString()) == 0) 
			System.out.println("It is a Palindrome");
		else 
			System.out.println("It is not a Palindrome");

	}
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		p.checkForPalindrome(new Scanner(System.in).nextLine());
	}
}