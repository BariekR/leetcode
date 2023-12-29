import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int min, int max) {
        if (min > max)
            return Arrays.asList((TreeNode) null);

        List<TreeNode> res = new ArrayList<>();

        for (int i = min; i <= max; ++i)
            for (TreeNode left : generateTrees(min, i - 1))
                for (TreeNode right : generateTrees(i + 1, max)) {
                    res.add(new TreeNode(i));
                    res.get(res.size() - 1).left = left;
                    res.get(res.size() - 1).right = right;
                }

        return res;
    }
}
