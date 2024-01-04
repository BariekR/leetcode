import java.util.ArrayList;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Node[]> levels = new ArrayList<>();
        levels.add(new Node[]{root});

        while(levels.get(levels.size() - 1)[0].left != null) {
            Node[] level = new Node[2 << (levels.size() - 1)];
            Node[] prevLevel = levels.get(levels.size() - 1);

            for (int i = 0, j = 0; i < prevLevel.length; i++) {
                level[j++] = prevLevel[i].left;
                if (i > 0) {
                    level[j-2].next = level[j-1];
                }
                level[j++] = prevLevel[i].right;
                level[j-2].next = level[j-1];
            }
            levels.add(level);
        }

        return root;
    }
}
