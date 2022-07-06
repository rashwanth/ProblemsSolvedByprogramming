import java.util.*;

public class FibonacciSumLastDigit {
	private static long getlength() {
		long prevs=2,currents=4,a=1,b=2,ans=1;
		while(prevs!=1 || currents!=2) {
			long t=a+b;
			a=b;
			b=t;
			prevs=currents;
			currents+=b;
			currents%=10;
			ans++;
		}
		return ans;
	}
    private static long getFibonacciSumNaive(long n) {
    	n=n%60;
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current);
            sum += current;
            sum=sum%10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
        
    }
}

