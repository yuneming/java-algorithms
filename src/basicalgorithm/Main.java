package basicalgorithm;

import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        int N = 20;
        int M = 100;
        SparseGraph g1 = new SparseGraph(N,false);
        DenseGraph g2 = new DenseGraph(N,false);
        for (int i = 0; i < M; i++){
            int a = (int)(Math.random()*N);
            int b = (int)(Math.random()*N);
            g2.addEdge(a,b);
        }
        for (int v = 0; v < N; v++){
            System.out.println(v+" : ");
            Iterable<Integer> adj = g2.adj(v);
            for (Integer it:adj) {
                System.out.println(it+" ");

            }
        }
    }
}
