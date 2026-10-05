import java.util.*;

class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        List<Integer> result = new ArrayList<>();

        boolean take = true;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {

                // Left → Right
                for (int j = 0; j < m; j++) {

                    if (take) {
                        result.add(grid[i][j]);
                    }

                    take = !take;
                }

            } else {

                // Right → Left
                for (int j = m - 1; j >= 0; j--) {

                    if (take) {
                        result.add(grid[i][j]);
                    }

                    take = !take;
                }
            }
        }

        return result;
    }
}