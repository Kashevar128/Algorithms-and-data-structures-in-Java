package lesson7;

import java.util.LinkedList;

public class DepthFirstPath extends FirstPath {

    public DepthFirstPath(Graph g, int source) {
        super(g, source);
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        getMarked()[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!getMarked()[w]) {
                getEdgeTo()[w] = v;
                dfs(g, w);
            }
        }
    }
}
