import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dest, int maxdist, int[] stops) {
        int count=0;
        int i=0;
        int lastrefill=0;
        while(i<stops.length && (lastrefill+maxdist)<dest) {
        	boolean counter=false;
        	while(i<stops.length && stops[i]<=(maxdist+lastrefill)) {
        		i++;
        		counter=true;
        	}
        	if(!counter)return -1;
        	lastrefill=stops[i-1];
        	count++;
        }
        if((lastrefill+maxdist)<dest) {
        	return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
