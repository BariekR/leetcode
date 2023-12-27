public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int counter = 1;
        int leftCounter = 0;
        int rightCounter = 0;

        if (root.left == null && root.right == null) {
            return counter;
        }

        if (root.left != null) {
            leftCounter += maxDepth(root.left);
        }

        if (root.right != null) {
            rightCounter += maxDepth(root.right);
        }

        counter += Math.max(leftCounter, rightCounter);
        return counter;
    }
}
