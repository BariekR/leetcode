import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int indexOfRootValInInorder = indexOf(inorder, preorder[0]);

        if (indexOfRootValInInorder != 0) {
            int[] inorderLeft = Arrays.copyOfRange(inorder, 0, indexOfRootValInInorder);
            int[] preorderLeft = Arrays.copyOfRange(preorder, 1, indexOfRootValInInorder + 1);
            root.left = buildTree(preorderLeft, inorderLeft);
        }

        if (inorder.length - indexOfRootValInInorder - 1 != 0) {
            int[] inorderRight = Arrays.copyOfRange(inorder, indexOfRootValInInorder + 1, inorder.length);
            int[] preorderRight = Arrays.copyOfRange(preorder, preorder.length - inorderRight.length, preorder.length);
            root.right = buildTree(preorderRight, inorderRight);
        }

        return root;
    }

    private int indexOf(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
