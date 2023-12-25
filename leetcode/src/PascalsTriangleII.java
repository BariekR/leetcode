import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }

        List<Integer> previousRow = getRow(rowIndex - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex) {
                result.add(1);
            } else {
                result.add(previousRow.get(i-1) + previousRow.get(i));
            }
        }

        return result;
    }
}
