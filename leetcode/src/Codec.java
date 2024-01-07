import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    private static final char nodeDelimiter = '_';

    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode fo = new TreeNode(4);
        TreeNode fi = new TreeNode(5);
        TreeNode th = new TreeNode(3);
        TreeNode tw = new TreeNode(2);
        TreeNode on = new TreeNode(1);
        TreeNode si = new TreeNode(6);
        TreeNode se = new TreeNode(7);
        th.left = fo;
        th.right = fi;
        on.left = tw;
        on.right = th;
        fo.left = si;
        fo.right = se;
        System.out.println(c.serialize(on));
        c.deserialize(c.serialize(on));
    }

    /*public String serializee(TreeNode root) {
        if (root == null) return "";

        List<TreeNode> last = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        last.add(root);
        sb.append(root.val);
        sb.append('x');

        while (!last.stream().allMatch(Objects::isNull)) {
            for (int i = 0; i < last.size(); i++) {
                TreeNode left = last.get(i) == null ? null : last.get(i).left;
                TreeNode right = last.get(i) == null ? null : last.get(i).right;
                current.add(left);
                current.add(right);

                if (left != null) {
                    sb.append(left.val);
                } else {
                    sb.append('N');
                }
                sb.append(nodeDelimiter);
                if (right != null) {
                    sb.append(right.val);
                } else {
                    sb.append('N');
                }
                sb.append(nodeDelimiter);
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append('x');
            last = current;
            current = new ArrayList<>();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        int nodes = 1;

        while (!q.stream().allMatch(Objects::isNull) || !((Math.log(nodes) / Math.log(2)) % 1 == 0)) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("N");
                if ((Math.log(nodes + 1) / Math.log(2)) % 1 == 0) {
                    sb.append('x');
                } else {
                    sb.append(nodeDelimiter);
                }
                q.add(null);
                q.add(null);
            } else {
                sb.append(node.val);
                if ((Math.log(nodes + 1) / Math.log(2)) % 1 == 0) {
                    sb.append('x');
                } else {
                    sb.append(nodeDelimiter);
                }
                q.add(node.left);
                q.add(node.right);
            }
            nodes++;
        }
        //sb.deleteCharAt(sb.length() - 1);
        //sb.append("xN_N_N_N_N_N_N_N_N_N_N_N_N_N_N_N");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, data.indexOf('x'))));
        queue.add(root);

        int beginIndex = 0;
        int endIndex = 0;
        long countX = data.chars().filter(ch -> ch == 'x').count();

        for (int i = 1; i < countX; i++) {
            beginIndex = data.indexOf("x", endIndex);
            endIndex = data.indexOf("x", beginIndex + 1);

            String[] level = data.substring(beginIndex + 1, endIndex).split(Character.toString(nodeDelimiter));
            int levelIndex = 0;
            int queueSize = queue.size();

            for (int j = 0; j < queueSize; j++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    queue.add(null);
                    queue.add(null);
                    levelIndex += 2;
                    continue;
                }
                String n1 = level[levelIndex];
                String n2 = level[levelIndex + 1];
                if (!n1.equals("N")) {
                    node.left = new TreeNode(Integer.parseInt(n1));
                }
                if (!n2.equals("N")) {
                    node.right = new TreeNode(Integer.parseInt(n2));
                }
                levelIndex += 2;
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }*/

    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append('N');
                sb.append(' ');
                continue;
            }
            sb.append(node.val);
            sb.append(' ');
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] st = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(st[0]));
        queue.add(root);

        for (int i = 1; i < st.length; i++) {
            TreeNode node = queue.poll();
            if (!st[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(st[i]));
                node.left = left;
                queue.add(left);
            }
            if (!st[++i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(st[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
