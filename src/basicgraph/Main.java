package basicgraph;



/**
 * 测试通过文件读取图的信息
 */
public class Main {
    public static void main(String[] args){

        // 测试图的联通分量
        String filename1 = "E:/algorithm/src//basicgraph/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "E:/algorithm/src//basicgraph/testG22.txt";
        SparseGraph g2 = new SparseGraph(7, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());

        // 使用两种图的存储方式读取testG1.txt文件
//        String filename = "E:/algorithm/src//basicgraph/testG1.txt";
//        SparseGraph g1 = new SparseGraph(13, false);
//        ReadGraph readGraph1 = new ReadGraph(g1, filename);
//        System.out.println("test G1 in Sparse Graph:");
//        g1.show();
//
//        System.out.println();
//
//        DenseGraph g2 = new DenseGraph(13, false);
//        ReadGraph readGraph2 = new ReadGraph(g2 , filename );
//        System.out.println("test G1 in Dense Graph:");
//        g2.show();
//
//        System.out.println();
//        // 使用两种图的存储方式读取testG2.txt文件
//        filename = "E:/algorithm/src//basicgraph/testG2.txt";
//        SparseGraph g3 = new SparseGraph(6, false);
//        ReadGraph readGraph3 = new ReadGraph(g3, filename);
//        System.out.println("test G2 in Sparse Graph:");
//        g3.show();
//
//        System.out.println();
//
//        DenseGraph g4 = new DenseGraph(6, false);
//        ReadGraph readGraph4 = new ReadGraph(g4, filename);
//        System.out.println("test G2 in Dense Graph:");
//        g4.show();



    }
}
