import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        if (root.left != null) {
            output.addAll(inorderTraversal(root.left));
        }

        output.add(root.val);

        if (root.right != null) {
            output.addAll(inorderTraversal(root.right));
        }

        return output;
    }
}
