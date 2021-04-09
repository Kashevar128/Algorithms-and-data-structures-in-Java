package lesson7;

import java.util.LinkedList;

public class FirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public boolean[] getMarked() {
        return marked;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    public int getSource() {
        return source;
    }

    public FirstPath(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
    }

    public boolean hasPathTo(int w) {
        return getMarked()[w];
    }

    public LinkedList<Integer> pathTo(int w) {
        if (!hasPathTo(w)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = w;
        while (vertex != getSource()) {
            stack.push(vertex);
            vertex = getEdgeTo()[vertex];
        }
        return stack;
    }

}
