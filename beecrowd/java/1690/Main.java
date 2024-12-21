import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr);
            
            long smallestMissingSum = 1; // The smallest sum that cannot be formed initially
            
            for (int i = 0; i < N; i++) {
                if (arr[i] > smallestMissingSum) {
                    break;
                }
                smallestMissingSum += arr[i]; // We can form sums up to smallestMissingSum + arr[i] - 1
            }
            
            System.out.println(smallestMissingSum);
        }
        
        sc.close();
    }
}