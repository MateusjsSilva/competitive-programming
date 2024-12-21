import java.util.*;

class Consultation implements Comparable<Consultation> {
    int start;
    int end;

    public Consultation(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Consultation other) {
        return this.end - other.end;
    }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Consultation[] consultations = new Consultation[N];

        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            consultations[i] = new Consultation(start, end);
        }

        Arrays.sort(consultations);

        int attended = 0;
        int lastEnd = 0;

        for (Consultation consultation : consultations) {
            if (consultation.start >= lastEnd) {
                attended++;
                lastEnd = consultation.end;
            }
        }

        System.out.println(attended);

        scanner.close();
    }
}