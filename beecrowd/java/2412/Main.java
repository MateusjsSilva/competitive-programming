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
        
        // Lê as coordenadas das árvores
        for (int i = 0; i < N; i++) {
            arvores[i][0] = sc.nextInt(); // X
            arvores[i][1] = sc.nextInt(); // Y
        }
        
        // Cria a lista de adjacência
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Conecta as árvores no grafo se a distância entre elas for <= D
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (distancia(arvores[i], arvores[j]) <= D * D) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        // Array de visitados
        visitado = new boolean[N];
        
        // Inicia a DFS a partir da primeira árvore
        dfs(0);

        // Verifica se todas as árvores foram visitadas
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

    // Função de DFS para explorar o grafo
    static void dfs(int node) {
        visitado[node] = true;
        for (int vizinho : adj.get(node)) {
            if (!visitado[vizinho]) {
                dfs(vizinho);
            }
        }
    }

    // Função para calcular a distância euclidiana ao quadrado entre duas árvores
    static int distancia(int[] arv1, int[] arv2) {
        int dx = arv1[0] - arv2[0];
        int dy = arv1[1] - arv2[1];
        return dx * dx + dy * dy;
    }
}