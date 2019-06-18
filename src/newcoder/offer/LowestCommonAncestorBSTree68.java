package newcoder.offer;

import sun.reflect.generics.tree.Tree;

public class LowestCommonAncestorBSTree68 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
         if (root == null) {
             return root;
         }
         if (root.val > A.val && root.val > B.val){
             return lowestCommonAncestor(root.left, A,B);
         }
         if (root.val < A.val && root.val < B.val) {
             return lowestCommonAncestor(root.right, A, B);
         }
         return root;
    }
}
