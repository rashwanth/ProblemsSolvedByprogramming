import java.util.*;

public class FibonacciHuge {
	private static long pisanoLength(long m) {
		long a=1,b=1;
		long ans=1;
		
		while(a!=0 || b!=1) {
			long t=a+b;
			a=b;
			b=t%m;;
			ans++;
		}
		return ans;
	}
	private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;
        n=n%pisanoLength(m);
        
        if(n==0)return 0;
        long previous = 0;
        long current  = 1;
        
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
        }
        
        return current%m ;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

