import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaves = leftToRightLeaves(root1);
        List<Integer> root2Leaves = leftToRightLeaves(root2);

        if (root1Leaves.size() != root2Leaves.size()) {
            return false;
        }

        for (int i = 0; i < root1Leaves.size(); i++) {
            if (!root1Leaves.get(i).equals(root2Leaves.get(i))) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> leftToRightLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return leaves;
        }

        List<Integer> leftLeaves = null;
        if (root.left != null) {
            leftLeaves = leftToRightLeaves(root.left);
        }
        List<Integer> rightLeaves = null;
        if (root.right != null) {
            rightLeaves = leftToRightLeaves(root.right);
        }

        if (leftLeaves != null) {
            leaves.addAll(leftLeaves);
        }
        if (rightLeaves != null) {
            leaves.addAll(rightLeaves);
        }

        return leaves;
    }
}
