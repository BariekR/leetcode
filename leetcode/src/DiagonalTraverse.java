public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0;
        int j = 0;
        int k = 0;
        int matLength = mat.length;
        int matILength = mat[0].length;
        boolean ascending = true;
        int[] result = new int[matLength * matILength];

        while (true) {
            if (i == matLength - 1 && j == matILength - 1) {
                result[k] = mat[matLength - 1][matILength - 1];
                return result;
            }
            result[k++] = mat[i][j];
            if (ascending) {
                if (i == 0 || j == matILength - 1) {
                    if (j + 1 < matILength) {
                        j++;
                    } else {
                        i++;
                    }
                    ascending = false;
                } else {
                    j++;
                    i--;
                }
            } else {
                if (j == 0 || i == matLength - 1) {
                    if (i + 1 < matLength) {
                        i++;
                    } else {
                        j++;
                    }
                    ascending = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
    }
}
