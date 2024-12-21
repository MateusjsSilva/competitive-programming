import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            // Array to store the wine demand/supply for each inhabitant
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            // Variable to store the total work required
            long work = 0;
            long balance = 0;

            // Calculating the necessary work
            for (int i = 0; i < n; i++) {
                balance += a[i];
                work += Math.abs(balance); // Add the absolute value of the balance to the work
            }

            System.out.println(work);
        }

        sc.close();
    }
}