import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visitado;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        
        int[][] arvores = new int[N][2];
        
        // Read the coordinates of the trees
        for (int i = 0; i < N; i++) {
            arvores[i][0] = sc.nextInt(); // X
            arvores[i][1] = sc.nextInt(); // Y
        }
        
        // Create the adjacency list
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Connect trees in the graph if the distance between them is <= D
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (distancia(arvores[i], arvores[j]) <= D * D) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        visitado = new boolean[N];
        
        // Start DFS from the first tree
        dfs(0);

        // Check if all trees have been visited
        boolean conectado = true;
        for (boolean v : visitado) {
            if (!v) {
                conectado = false;
                break;
            }
        }

        System.out.println(conectado ? "S" : "N");
        sc.close();
    }

    // DFS function to explore the graph
    static void dfs(int node) {
        visitado[node] = true;
        for (int vizinho : adj.get(node)) {
            if (!visitado[vizinho]) {
                dfs(vizinho);
            }
        }
    }

    // Function to calculate the squared Euclidean distance between two trees
    static int distancia(int[] arv1, int[] arv2) {
        int dx = arv1[0] - arv2[0];
        int dy = arv1[1] - arv2[1];
        return dx * dx + dy * dy;
    }
}