import java.util.*;

public class CoveringSegments {
	private static void sortOnLength(int[] arr) {
		for(int i=0;i<arr.length;i+=2) {
			for(int j=i+2;j<arr.length;j+=2) {
				if(arr[i]>arr[j]) {
					int t=arr[i];
					arr[i]=arr[j];
					arr[j]=t;
					
					t=arr[i+1];
					arr[i+1]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		return;
	}
    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];

        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        sortOnLength(points);
        boolean encounter=true;
        boolean visited[]=new boolean[segments.length];
        
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        
        while(encounter) {
        	encounter=false;
        	int ans[]=new int[2];
        	
        	for(int i=0;i<points.length;i+=2) {
        		if(!visited[i/2] && !encounter) {
        			ans[0]=points[i];
        			ans[1]=points[i+1];
        			visited[i/2]=true;
        			encounter=true;
        		}
        		if(visited[i/2])continue;
        		
        		int current1=points[i],current2=points[i+1];
        		
        		if((current1<ans[0] && current2<ans[0]) || (current1>ans[1] && current2>ans[1]))continue;
        		
        		ans[0]=Math.max(ans[0], current1);
        		ans[1]=Math.min(ans[1], current2);
        		
        		visited[i/2]=true;
        		encounter=true;
        	}
        	
        	if(!encounter)break;
        	arrayList.add(ans[0]);
        }
        
        System.out.println(arrayList.size());
        for(int i=0;i<arrayList.size();++i)System.out.print(arrayList.get(i)+" ");
        
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        optimalPoints(segments);
        
    }
}
 
