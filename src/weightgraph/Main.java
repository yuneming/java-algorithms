package weightgraph;

import java.util.Vector;

/**
 * // 测试通过文件读取图的信息
 */
public class Main {
    // 测试通过文件读取图的信息
    public static void main(String[] args) {
        // 测试我们实现的两种Prim算法的性能差距
        // 可以看出这一节使用索引堆实现的Prim算法优于上一小节的Lazy Prim算法
        String filename1 = "E:/algorithm/src//weightgraph/testG1.txt";
        int V1 = 8;

        String filename2 = "E:/algorithm/src//weightgraph/testG2.txt";
        int V2 = 250;
        // 文件读取
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<Double>(V1, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename1);
        System.out.println( filename1 + " load successfully.");

        SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<Double>(V2, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, filename2);
        System.out.println( filename2 + " load successfully.");

        long startTime, endTime;

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST1 = new LazyPrimMST<Double>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST2 = new LazyPrimMST<Double>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

        // Test Prim MST
        System.out.println("Test Prim MST:");

        startTime = System.currentTimeMillis();
        PrimeMST<Double> primMST1 = new PrimeMST<Double>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        PrimeMST<Double> primMST2 = new PrimeMST<Double>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

//        // 测试简单的prime算法
//        String filename = "E:/algorithm/src//weightgraph/testG1.txt";
//        int V = 8;
//
//        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
//        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);
//
//        // Test Lazy Prim MST
//        System.out.println("Test Lazy Prim MST:");
//        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
//        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
//        for( int i = 0 ; i < mst.size() ; i ++ )
//            System.out.println(mst.elementAt(i));
//        System.out.println("The MST weight is: " + lazyPrimMST.result());
//
//        System.out.println();

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
