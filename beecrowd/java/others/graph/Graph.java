import java.util.ArrayList;
import java.util.List;

public class Graph 
{
    private int vertices;
    private List<List<int[]>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdgeDirected(int u, int v) {
        adjList.get(u).add(new int[]{v, 0});
    }

    public void addEdgeUndirected(int u, int v) {
        adjList.get(u).add(new int[]{v, 0});
        adjList.get(v).add(new int[]{u, 0});
    }

    public void addEdgeDirected(int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
    }

    public void addEdgeUndirected(int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }

    public List<int[]> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getVertices() {
        return vertices;
    }

    public void printAdjacencyList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int[] neighbor : adjList.get(i)) {
                System.out.print("{" + neighbor[0] + ", " + neighbor[1] + "} ");
            }
            System.out.println();
        }
    }
}