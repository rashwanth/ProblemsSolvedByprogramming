import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        while(capacity>0) {
        	int ind=-1;
        	double max=-1;
        	for(int i=0;i<values.length;++i) {
        		if(weights[i]==0)continue;
        		double var=values[i]/(double)weights[i];
        		if(var>max) {
        			max=var;
        			ind=i;
        		}
        	}
        	if(max==-1)break;
        	int currentSize=Math.min(capacity,weights[ind]);
        	value+=(max*(double)currentSize);
        	capacity-=currentSize;
        	weights[ind]=weights[ind]-currentSize;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f",getOptimalValue(capacity, values, weights));
    }
} 
