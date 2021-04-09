package lesson7;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
//        Graph graph = new Graph(10);
//        graph.addEdge(1,2);
//        graph.addEdge(0,4);
//        graph.addEdge(1,4);
//        graph.addEdge(3,4);
//        graph.addEdge(7,8);
//
//        graph.addEdge(0,1);
//
//        System.out.println(graph.getAdjList(4));
//
//        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
//        System.out.println(dfp.hasPathTo(2));
//        System.out.println(dfp.pathTo(2));
//
//        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 0);
//        System.out.println(bfp.hasPathTo(2));
//        System.out.println(bfp.pathTo(2));

        Graph graph2 = new Graph(10);
        graph2.addEdge(9, 8);
        graph2.addEdge(8, 3);
        graph2.addEdge(3, 2);
        graph2.addEdge(2, 4);
        graph2.addEdge(4, 5);
        graph2.addEdge(5, 6);
        graph2.addEdge(6, 9);
        graph2.addEdge(9, 7);
        graph2.addEdge(7, 4);
        graph2.addEdge(1, 0);

        System.out.println(graph2.getAdjList(9));
        DepthFirstPath dfp2 = new DepthFirstPath(graph2,9);
        System.out.println(dfp2.hasPathTo(0));
        System.out.println(dfp2.hasPathTo(5));

        BreadthFirstPath bfp2 = new BreadthFirstPath(graph2, 9);
        System.out.println(bfp2.pathTo(4)); //правильно!!



    }
}
