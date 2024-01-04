import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node last = queue.poll();

                if(last.left!=null){
                    queue.add(last.left);
                }
                if(last.right!=null){
                    queue.add(last.right);
                }
                if(i != size - 1){
                    last.next=queue.peek();
                }
            }
        }

        return root;
    }
}
