import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MAX_C = 70;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int N = scanner.nextInt(); // Number of words
            int L = scanner.nextInt(); // Lines per page
            int C = scanner.nextInt(); // Characters per line

            int numLines = 0, space = 0, currentLine = 0;

            for (int i = 0; i < N; i++) {
                String word = scanner.next();
                int wordLength = word.length();

                if (currentLine + wordLength + space <= C) {
                    currentLine += wordLength + space;
                } else {
                    numLines++;
                    currentLine = wordLength;
                }
                space = 1; // Adds space between words
            }

            if (currentLine > 0) {
                numLines++;
            }

            int numPages = (numLines + L - 1) / L; // Calculate the number of pages
            System.out.println(numPages);
        }

        scanner.close();
    }
}