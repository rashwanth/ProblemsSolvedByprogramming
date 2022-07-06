import java.util.*;

public class LCM {
	private static int gcd_naive(int a, int b) {
	    
		while(b!=0) {
			int t=a%b;
			a=b;
			b=t;
		}
	    

	    return a;
	 }
	private static long lcm_naive(int a, int b) {
		return ((long)a*(long)b) / (long)gcd_naive(a, b);
	}

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
