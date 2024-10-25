import java.util.ArrayList;
import java.util.List;

public class GraphSearch 
{
    private Graph graph;
    private boolean[] visited;

    public GraphSearch(Graph graph) 
    {
        this.graph = graph;
        visited = new boolean[graph.getVertices() + 1];
    }

    // Method to check if the graph is connected
    public boolean isConnected(int node) 
    {
        dfs(node);
        
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    // Perform DFS
    private void dfs(int vertex) 
    {
        visited[vertex] = true;
        for (int[] neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor[0]]) {
                dfs(neighbor[0]);
            }
        }
    }

    // Method for finding and displaying connected components
    public void findConnectedComponents() 
    {
        visited = new boolean[graph.getVertices()];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfsComponent(i, component);
                components.add(component);
            }
        }

        System.out.println("Componentes Conectadas:");
        for (List<Integer> component : components) {
            System.out.println(component);
        }
    }

    // DFS to capture a connected component
    private void dfsComponent(int vertex, List<Integer> component) 
    {
        visited[vertex] = true;
        component.add(vertex);

        for (int[] neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor[0]]) {
                dfsComponent(neighbor[0], component);
            }
        }
    }

    public boolean containsCycle() {
        boolean[] recStack = new boolean[graph.getVertices()];
        for (int i = 1; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (dfsCycleDetect(i, -1, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // This DFS checks for back edges indicating cycles.
    private boolean dfsCycleDetect(int vertex, int parent, boolean[] recStack) {
        visited[vertex] = true;
        recStack[vertex] = true;

        for (int[] neighbor : graph.getNeighbors(vertex)) {
            int neighborVertex = neighbor[0];
            if (!visited[neighborVertex]) {
                if (dfsCycleDetect(neighborVertex, vertex, recStack)) {
                    return true;
                }
            } else if (neighborVertex != parent && recStack[neighborVertex]) {
                System.out.println("Ciclo encontrado em componente contendo: ");
                return true;
            }
        }
        recStack[vertex] = false;
        return false;
    }

    // Method to check if the graph is bipartite
    public boolean isBipartite() {
        int[] colors = new int[graph.getVertices()];
        for (int i = 1; i < graph.getVertices(); i++) {
            if (colors[i] == 0) {
                if (!dfsCheck(i, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // DFS method to check if it is bipartite
    private boolean dfsCheck(int vertex, int[] colors, int color) {
        colors[vertex] = color;

        for (int[] neighbor : graph.getNeighbors(vertex)) {
            int neighborVertex = neighbor[0];
            if (colors[neighborVertex] == 0) {
                if (!dfsCheck(neighborVertex, colors, -color)) {
                    return false;
                }
            } else if (colors[neighborVertex] == colors[vertex]) {
                return false;
            }
        }
        return true;
    }
}