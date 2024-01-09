import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int topBoundary = 0;
        int rightBoundary = matrix[0].length;
        int bottomBoundary = matrix.length;
        int leftBoundary = -1;

        int i = 0;
        int j = 0;
        boolean toRight = true;
        boolean toBottom = false;
        boolean toLeft = false;
        boolean toTop = false;

        while (result.size() < matrix.length * matrix[0].length) {
            result.add(matrix[i][j]);
            if (toRight) {
                if (j + 1 == rightBoundary) {
                    i++;
                    rightBoundary--;
                    toBottom = true;
                    toRight = false;
                } else {
                    j++;
                }
            } else if (toBottom) {
                if (i + 1 == bottomBoundary) {
                    j--;
                    bottomBoundary--;
                    toBottom = false;
                    toLeft = true;
                } else {
                    i++;
                }
            } else if (toLeft) {
                if (j - 1 == leftBoundary) {
                    i--;
                    leftBoundary++;
                    toTop = true;
                    toLeft = false;
                } else {
                    j--;
                }
            } else if (toTop) {
                if (i - 1 == topBoundary) {
                    j++;
                    topBoundary++;
                    toTop = false;
                    toRight = true;
                } else {
                    i--;
                }
            }
        }

        return result;
    }
}
