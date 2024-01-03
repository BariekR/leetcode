public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;

        if (root == null) return false;

        sum += root.val;

        if (root.left == null && root.right == null && sum == targetSum) {
            return true;
        }

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum - sum)) {
                return true;
            }
        }
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum - sum)) {
                return true;
            }
        }

        return false;
    }
}
