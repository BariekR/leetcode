import java.util.ArrayList;
import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int indexOfRootValInInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                indexOfRootValInInorder = i;
                break;
            }
        }

        if (indexOfRootValInInorder != 0) {
            int[] inorderLeft = new int[indexOfRootValInInorder];
            inorderLeft = Arrays.copyOfRange(inorder, 0, indexOfRootValInInorder);
            int[] postorderLeft = new int[inorderLeft.length];
            postorderLeft = Arrays.copyOfRange(postorder, 0, postorderLeft.length);
            root.left = buildTree(inorderLeft, postorderLeft);
        }

        if (inorder.length - indexOfRootValInInorder - 1 != 0) {
            int[] inorderRight = new int[inorder.length - indexOfRootValInInorder - 1];
            inorderRight = Arrays.copyOfRange(inorder, indexOfRootValInInorder + 1, inorder.length);
            int[] postorderRight = new int[inorderRight.length];
            postorderRight = Arrays.copyOfRange(postorder, postorder.length - 1 - inorderRight.length, postorder.length - 1);
            root.right = buildTree(inorderRight, postorderRight);
        }

        return root;
    }
}
