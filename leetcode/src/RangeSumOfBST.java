public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root.left == null && root.right == null) {
            if (root.val >= low && root.val <= high) {
                return root.val;
            } else {
                return 0;
            }
        }

        int leftSum = 0;
        if (root.left != null) {
            leftSum += rangeSumBST(root.left, low, high);
        }

        int rightSum = 0;
        if (root.right != null) {
            rightSum += rangeSumBST(root.right, low, high);
        }

        return (root.val >= low && root.val <= high)
                ? root.val + leftSum + rightSum : leftSum + rightSum;
    }
}
