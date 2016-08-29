
import java.util.Scanner;

class Transpose {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[][] mat = new int[4][4];
		int i=0,j;
		while(i<3) {
			j=0;
			while(j<3)
				mat[i][j++]= s.nextInt();
			i++;
		}
		System.out.println("==========================");
		i=0;
		int flag =0;
		while(i<3) {
			j=0;
			while(j<3) {
				if(mat[i][j]!=mat[j][i])
					flag = 1;
				j++;
			}
			i++;
		}

		if(flag == 1) 
			System.out.println("Not Symertric");
		else 
			System.out.println("Symertric");
	}
}