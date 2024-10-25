import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Graph graph = readGraph();
        GraphSearch search = new GraphSearch(graph);

        // graph.printAdjacencyList();

        if (search.isConnected(0)) {
            System.out.println("O grafo é conexo.");
        } else {
            System.out.println("O grafo não é conexo.");
            search.findConnectedComponents();
        }

        if (search.isBipartite()) {
            System.out.println("O grafo é bipartido.");
        } else {
            System.out.println("O grafo não é bipartido.");
        }
    }

    public static Graph readGraph() 
    {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        //System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        Graph graph = new Graph(vertices);

        //System.out.println("Enter edges (format: u v weight):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdgeUndirected(u, v, weight);
        }

        scanner.close();
        return graph;
    }
}