import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int N = scanner.nextInt(); // Number of matches
            int G = scanner.nextInt(); // Available goals

            int points = 0;
            int[] differences = new int[N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                int S = scanner.nextInt(); // Goals scored by the team
                int R = scanner.nextInt(); // Goals conceded by the team

                if (S > R) {
                    points += 3; // Win gives 3 points
                } else {
                    differences[count++] = R - S; // Store goal difference for ties/losses
                }
            }

            // Sort differences in ascending order
            Arrays.sort(differences, 0, count);

            for (int i = 0; i < count; i++) {
                if (G > differences[i]) {
                    points += 3; // Convert to a win
                    G -= (differences[i] + 1); // Use enough goals to win
                } else if (G == differences[i]) {
                    points += 1; // Convert to a draw
                    G -= differences[i]; // Use exact goals to draw
                } else {
                    break; // No more goals to use
                }
            }

            System.out.println(points);
        }

        scanner.close();
    }
}