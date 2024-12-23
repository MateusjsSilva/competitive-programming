import java.util.*;

public class PossibleSums {

    // Function to find all possible sums that can be formed with the given weights
    public static Set<Integer> possibleSums(int capacity, List<Integer> weights) {
        Set<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0); // Initially, the sum 0 is always possible

        for (int weight : weights) {
            List<Integer> newSums = new ArrayList<>();
            for (int currentSum : possibleSums) {
                int newSum = currentSum + weight;
                if (newSum <= capacity) {
                    newSums.add(newSum);
                }
            }
            possibleSums.addAll(newSums); // Add the new sums to the set
        }

        return possibleSums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTRADA:");
        int testCases = scanner.nextInt();

        // Process each test case
        while (testCases-- > 0) {
            int n = scanner.nextInt(); // number of weights
            int capacity = scanner.nextInt(); // maximum capacity of the knapsack

            List<Integer> weights = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                weights.add(scanner.nextInt());
            }

            // Get the possible sums for the given capacity and weights
            Set<Integer> result = possibleSums(capacity, weights);

            System.out.printf("SAIDA:\n");
            for (int sum : result) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}