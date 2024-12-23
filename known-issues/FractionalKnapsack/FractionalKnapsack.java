import java.util.*;

public class FractionalKnapsack {

    // Class to represent an item with weight, value, and cost-benefit ratio
    static class Item {
        int weight;
        int value;
        double costBenefit;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.costBenefit = (double) value / weight;
        }
    }

    // Function to solve the fractional knapsack problem
    public static double fractionalKnapsack(int capacity, List<Item> items) {
        // Sort items by cost-benefit ratio in descending order
        items.sort((a, b) -> Double.compare(b.costBenefit, a.costBenefit));

        double maxValue = 0.0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                // If the whole item can be taken, take it
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                // Take a fraction of the item
                maxValue += item.costBenefit * capacity;
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTRADA:");
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt(); // number of items
            int capacity = scanner.nextInt(); // maximum capacity of the knapsack

            List<Item> items = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int weight = scanner.nextInt();
                int value = scanner.nextInt();
                items.add(new Item(weight, value));
            }

            // Calculate and print the maximum value that can be carried in the knapsack
            double maxValue = fractionalKnapsack(capacity, items);

            System.out.printf("SAIDA:\n%.2f", maxValue);
        }

        scanner.close();
    }
}