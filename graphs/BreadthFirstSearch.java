import java.util.*;

public final class BreadthFirstSearch
{
    private static boolean[] _visited;
    private static Queue<Integer> _queue = new LinkedList<Integer>();

    private BreadthFirstSearch() {
        // empty constructor;
    }

    public static void BFS(Graph g, int node) {
        _visited = new boolean[g.getNumVertices()];
        for (int i = 0; i < g.nodes.length; i++) {
            ArrayList<Integer> n = g.nodes[i];
            if (!n.isEmpty()) {
                if (!_visited[i]) {
                    _queue.add(i);
                    System.out.print(i + " -> ");

                    while (!_queue.isEmpty()) {
                        int top = _queue.poll();
                        if (!_visited[top]) {
                            _visited[top] = true;
                            for (int child : g.nodes[top]) {
                                if (!_visited[child]) {
                                    _queue.add(child);
                                    System.out.print(child + " -> ");
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("done");
    }
}
