package newcoder.offer;

public class MirrorBTree27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public void Mirror(TreeNode root) {
            if (root == null)
                return;
            swap(root);
            Mirror(root.left);
            Mirror(root.right);
        }

        private void swap(TreeNode root) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
        }
    }
}
