import java.util.*;

public class FibonacciPartialSum {
	private static long getFibonacciPartialSumNaive(long input) {
	    if(input<=2)return input;
	    
		long prevs=2,currents=4,a=1,b=2,ans=3;
		while(ans<input) {
			long t=a+b;
			a=b;
			b=t;
			prevs=currents;
			currents+=b;
			currents%=10;
			ans++;
		}
		return currents;
	}
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        from= from%60 == 0 ? 60: from%60 ;
        to= to%60==0 ? 60: to%60 ;
        
        long ans=getFibonacciPartialSumNaive(to)-getFibonacciPartialSumNaive(from-1);
        if(ans<0)ans+=10;
        System.out.println(ans);
    }
}
