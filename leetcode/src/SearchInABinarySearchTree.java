public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }
        TreeNode result = null;

        if (root.left != null) {
            result = searchBST(root.left, val);
            if (result != null) {
                return result;
            }
        }
        if (root.right != null) {
            result = searchBST(root.right, val);
            if (result != null) {
                return result;
            }
        }

        return result;
    }
}
