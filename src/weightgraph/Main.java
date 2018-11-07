package weightgraph;

import java.util.Vector;

/**
 * // 测试通过文件读取图的信息
 */
public class Main {
    // 测试通过文件读取图的信息
    public static void main(String[] args) {

        // 测试简单的prime算法
        String filename = "E:/algorithm/src//weightgraph/testG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();

        // 使用两种图的存储方式读取testG1.txt文件
//        String filename = "E:/algorithm/src//weightgraph/testG1.txt";
//        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<Double>(8, false);
//        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename);
//        System.out.println("test G1 in Sparse Weighted Graph:");
//        g1.show();
//
//        System.out.println();
//
//        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<Double>(8, false);
//        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2 , filename );
//        System.out.println("test G1 in Dense Graph:");
//        g2.show();
//
//        System.out.println();
    }
}
