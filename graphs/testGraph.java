import java.util.*;

public class testGraph
{
    public static void main(String[] args) {
        Graph g = new Graph(5, 0);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 5);
        g.addEdge(2, 4);
        System.out.println(g);
        DepthFirstSearch.DFS(g, 0);
    }
}
