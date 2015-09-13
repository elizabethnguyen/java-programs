import java.util.*;

public final class DepthFirstSearch
{
    private static boolean[] _visited;

    private DepthFirstSearch() {
        // empty constructor;
    }

    public static void DFS(Graph g, int node) {
        _visited = new boolean[g.getNumVertices()];
        System.out.println("DFS Traversal Order: ");
        for (int i = 0; i < g.nodes.length; i++) {
            ArrayList<Integer> n = g.nodes[i];
            if (!n.isEmpty()) {
                if (!_visited[i]) {
                    _visited[i] = true;
                    System.out.print(i + " -> ");
                    DFS_visit(g, g.nodes[i], i);
                }
            }
        }
        System.out.println("done");
    }

    public static void DFS_visit(Graph g, ArrayList<Integer> V, int i) {
        for (int v : V) {
            if (!_visited[v]) {
                System.out.print(v + " -> ");
                _visited[v] = true;
                DFS_visit(g, g.nodes[v], v);
            }
        }
    }

    public static void topologicalSort(Graph g, int node) {
        _visited = new boolean[g.getNumVertices()];
        System.out.println("DFS Traversal Order: ");
        for (int i = 0; i < g.nodes.length; i++) {
            ArrayList<Integer> n = g.nodes[i];
            if (!n.isEmpty()) {
                if (!_visited[i]) {
                    _visited[i] = true;
                    System.out.print(i + " -> ");
                    DFS_visit_topo(g, g.nodes[i], i);
                }
            }
        }
        System.out.println("done");
    }

    public static void DFS_visit_topo(Graph g, ArrayList<Integer> V, int i) {
        for (int v : V) {
            if (!_visited[v]) {
                System.out.print(v + " -> ");
                _visited[v] = true;
                DFS_visit(g, g.nodes[v], v);
            }
        }
    }
}
