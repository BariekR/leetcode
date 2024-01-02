import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public boolean isSymmetricOld(TreeNode root) {
        List<List<Integer>> levelOrder = levelOrder(root);

        for (List<Integer> level : levelOrder) {
            if (!isSymmetric(level)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSymmetric(List<Integer> levelValues) {
        for (int i = 0; i < levelValues.size() / 2; i++) {
            Integer left = levelValues.get(i);
            Integer right = levelValues.get(levelValues.size() - 1 - i);
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (!left.equals(right)) {
                return false;
            }
        }
        return true;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        List<TreeNode> currentLevelNodes = new ArrayList<>();
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        currentLevelNodes.add(root);

        while (!currentLevelNodes.isEmpty()) {
            List<Integer> lastOutputLine = new ArrayList<>();
            output.add(lastOutputLine);

            for (TreeNode node : currentLevelNodes) {
                if (node == null) {
                    lastOutputLine.add(null);
                    continue;
                }

                lastOutputLine.add(node.val);

                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);
            }

            currentLevelNodes = nextLevelNodes;
            nextLevelNodes = new ArrayList<>();
        }

        return output;
    }
}
