import java.util.Scanner;
import java.io.*;
class HelloWorld {
	public static void main(String[] args) throws IOException {
			String s;
			int a = 0, e = 0, i = 0, o = 0, u = 0;
			char c;
      Scanner scanner = new Scanner(System.in);
      s = scanner.nextLine();
			while(s != null && !s.isEmpty()) {

					for(int j=0;j<s.length();j++) {
							c = s.charAt(j);
							if(c=='a'||c=='A')
								a++;
							else if(c=='e'||c=='E')
									e++;
							else if(c=='i'||c=='I')
									i++;
							else if(c=='o'||c=='O')
									o++;
							else if(c=='u'||c=='U')
									u++;
						  s = scanner.nextLine();
					}
		}
		System.out.print("A :"  + a);
		System.out.print("E :"  + e);
		System.out.print("I :"  + i);
		System.out.print("O :"  + o);
		System.out.print("U :"  + u);
}
