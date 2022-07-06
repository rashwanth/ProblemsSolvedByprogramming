import java.util.Scanner;

public class Change {
    private static int getChange(int n) {
    	
        //write your code here
        return (n/10)+((n%10)/5)+((n%10)%5);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

