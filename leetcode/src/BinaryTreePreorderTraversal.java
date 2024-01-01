import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }
        output.add(root.val);

        if (root.left != null) {
            output.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            output.addAll(preorderTraversal(root.right));
        }

        return output;
    }
}
