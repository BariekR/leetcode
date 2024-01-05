public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = null;
        if (root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }

        TreeNode right = null;
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }

        if (left == p && right == q || left == q && right == p) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        if (right != null) {
            return right;
        }
        if (left != null) {
            return left;
        }

        return null;
    }
}
