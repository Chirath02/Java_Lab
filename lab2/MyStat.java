import java.util.Scanner;
import java.lang.*;

class MyStat {
	int[] numbers = new int[100];
	int n;

	void input() {
		Scanner s = new Scanner(System.in);
 		for(int i=0;i<n;++i)
			numbers[i++] = s.nextInt();
		
	}

	MyStat(int n) {
		this.n = n;
	}

	float getSum() {
		float sum = 0;
		for(int i=0;i<n;++i)
			sum += numbers[i];
		return sum;
	}

	float avg() {
		float sum = this.getSum();
		return sum / n;
	}

	int mode() {
		int count = 0, modeElement = 0, maxCount=0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(numbers[i] == numbers[j])
					count++;
			}
			if(count > maxCount) {
				maxCount = count;
				modeElement = numbers[i];
			}
			count =0;
		}
		return modeElement;
	}

	float standardDevaition() {
		float sum = this.getSum();
		return 0;
	}

	float variance() {
		float sum = this.getSum();
		return 0;
	}

	public static void main(String[] args) {
		MyStat m = new MyStat(10);
		m.input();
		System.out.println("Average : " + m.avg());
		System.out.println("Mode " + m.mode());
	}
}