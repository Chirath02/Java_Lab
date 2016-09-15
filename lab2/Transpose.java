
import java.util.Scanner;

class Transpose {
	int[][] mat = new int[1000][1000];
	int n;
	Scanner s = new Scanner(System.in);

	void checkTranspose() {
		System.out.println("==========================");
		int i=0, j;

		while(i<n) {
			j=0;
			while(j<n)
				System.out.print(mat[i][j++] + " ");
			i++;
			System.out.println();
		}
		System.out.println("==========================");
		i = 0;
		int flag =0;
		while(i<n) {
			j=0;
			while(j<n) {
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

	void inputMat() {
		int i=0, j;
		System.out.println("Order(n)? : ");
		n = s.nextInt();
		while(i<n) {
			j=0;
			while(j<n)
				mat[i][j++]= s.nextInt();
			i++;
		}
	}


	public static void main(String[] args) {
		Transpose T = new Transpose();
		T.inputMat();
		T.checkTranspose();
	}
}