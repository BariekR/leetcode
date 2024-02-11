import java.util.HashMap;

public class CherryPickupII {
    public static void main(String[] args) {
        CherryPickupII c = new CherryPickupII();
        int[][] p = new int[][]{{1,0,0,3},{0,0,0,3},{0,0,3,3},{9,0,3,3}};
        System.out.println(c.cherryPickup(p));
    }

    public int cherryPickup(int[][] grid) {
        HashMap<String, Integer> memory = new HashMap<>();
        return rec(0, 0, grid[0].length - 1, grid, memory);
    }

    public int rec(int row, int col1, int col2, int[][] grid, HashMap<String, Integer> memory) {
        String mKey = row + "-" + col1 + "-" + col2;
        if (memory.get(mKey) != null) {
            return memory.get(mKey);
        }
        if (row == grid.length) {
            return 0;
        }

        int cherryNextRow = 0;
        int cherry = grid[row][col1] + (col1 == col2 ? 0 : grid[row][col2]);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newCol1 = col1 + i;
                int newCol2 = col2 + j;

                if (0 <= newCol1 && newCol1 < grid[0].length && 0 <= newCol2 && newCol2 < grid[0].length) {
                    cherryNextRow = Math.max(cherryNextRow, rec(row + 1, newCol1, newCol2, grid, memory));
                }
            }
        }

        int res = cherryNextRow + cherry;
        memory.put(mKey, res);
        return res;
    }
}
