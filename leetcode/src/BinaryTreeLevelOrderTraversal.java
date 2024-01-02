import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                lastOutputLine.add(node.val);

                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }

            currentLevelNodes = nextLevelNodes;
            nextLevelNodes = new ArrayList<>();
        }

        return output;
    }
}
