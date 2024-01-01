import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        if (root.left != null) {
            output.addAll(postorderTraversal(root.left));
        }

        if (root.right != null) {
            output.addAll(postorderTraversal(root.right));
        }

        output.add(root.val);

        return output;
    }
}
