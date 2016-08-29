import java.util.Scanner;
import java.lang.*;

class MyStat {
	int[] numbers = new int[1000];
	int n;

	void input() {
		Scanner s = new Scanner(System.in);
 		for(int i=0;i<n;++i)
			numbers[i] = (int )(Math.random() * 500 + 1);
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

	float getAvg() {
		float sum = this.getSum();
		return sum / n;
	}

	int getMode() {
		int count = 1 , modeElement = numbers[0], maxCount=0;
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				if(numbers[i] == numbers[j])
					count++;
			}
			if(count > maxCount) {
				maxCount = count;
				modeElement = numbers[i];
			}
			count = 0;
		}
		return modeElement;
	}

	double getStandardDevaition() {
		float variance = getVariance();
		return Math.sqrt(variance);
	}

	float getVariance() {
		float avg = this.getSum(), variance = 0;
		for(int i=0;i < n;++i)
			variance += (numbers[i]-avg) * (numbers[i]-avg);
		return variance/(n*n);
	}

	public static void main(String[] args) {
		MyStat m = new MyStat(1000);
		m.input();
		System.out.println("Average : " + m.getAvg());
		System.out.println("Mode " + m.getMode());
		System.out.println("Variance " + m.getVariance());
		System.out.println("Standard deviation " + m.getStandardDevaition());
	}
}
