package newcoder.offer;


import java.util.HashMap;

public class ReconstructBinaryTree7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 缓存中序遍历数组每个值对应的索引
    private HashMap<Integer,Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i],i);
        }
        return reConstructBinaryTree(pre,0,pre.length-1,0);

    }
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        // 从前序遍历找根
        TreeNode root = new TreeNode(pre[preL]);

        // 根在中序遍历中的位置
        int inIndex = indexForInOrders.get(root.val);
        // 左子树大小,inL是树在in中最左边的位置
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

}
