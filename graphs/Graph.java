import java.util.*;

public class Graph
{
    private int _vertices;
    private int _edges;
    public ArrayList<Integer>[] nodes;

    @SuppressWarnings("unchecked")
    public Graph(int vertices, int edges) {
        _vertices = vertices+1;
        _edges = edges;
        nodes = (ArrayList<Integer>[]) new ArrayList[_vertices];

        for (int i = 0; i < _vertices; i++) {
            nodes[i] = new ArrayList<Integer>();
        }
    }

    public ArrayList<Integer> getAdjList(int v) {
        return nodes[v];
    }

    public void addEdge(int a, int b) {
        nodes[a].add(b);
        _edges++;
    }

    public int getNumVertices() {
        return _vertices;
    }

    public int getNumEdges() {
        return _edges;
    }

    public String toString() {
        String result = "";

        for (int i = 0; i < _vertices; i++) {
            result += i + ": ";
            for (int j : nodes[i]) {
                result += (j + " ");
            }
            result += "\n";
        }
        return result;
    }
}
