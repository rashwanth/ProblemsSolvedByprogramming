import java.util.*;

public class LargestNumber {
    private static String comp(String a,String b) {
    	if(b.equals(""))return a;
    	int t1=Integer.parseInt(a+b);
    	int t2=Integer.parseInt(b+a);
    	if(t1>t2) {
    		return a;
    	}
    	return b;
    }
	private static String largestNumber(String[] arr) {
    	
        //write your code here
        String result="";
        for (int i = 0; i < arr.length; i++) {
        	String var="";
        	int ind=-1;
        	for(int j=0;j<arr.length;++j) {
        		if(arr[j].equals("."))continue;
        		String temp=comp(arr[j],var);
        		if(temp.equals(arr[j])) {
        			ind=j;
        			var=temp;
        		}
        	}
        	result=result+var;
        	arr[ind]=".";
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

