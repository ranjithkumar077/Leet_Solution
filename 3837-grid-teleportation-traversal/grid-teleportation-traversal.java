import java.util.*;

class Solution {
    public int minMoves(String[] matrix) {

        int m = matrix.length;
        int n = matrix[0].length();

        // Store all positions of each portal A-Z
        List<int[]>[] portals = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            portals[i] = new ArrayList<>();
        }

        // Preprocess portals
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = matrix[i].charAt(j);

                if (ch >= 'A' && ch <= 'Z') {
                    portals[ch - 'A'].add(new int[]{i, j});
                }
            }
        }

        // Distance array
        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();

        dist[0][0] = 0;
        deque.addFirst(new int[]{0, 0});

        // Each portal letter can be expanded only once
        boolean[] usedPortal = new boolean[26];

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        while (!deque.isEmpty()) {

            int[] current = deque.pollFirst();

            int r = current[0];
            int c = current[1];

            int currentDist = dist[r][c];

            // Destination
            if (r == m - 1 && c == n - 1) {
                return currentDist;
            }

            char ch = matrix[r].charAt(c);

            // -------------------------
            // TELEPORTATION - COST 0
            // -------------------------
            if (ch >= 'A' && ch <= 'Z') {

                int portalIndex = ch - 'A';

                if (!usedPortal[portalIndex]) {

                    usedPortal[portalIndex] = true;

                    for (int[] pos : portals[portalIndex]) {

                        int nr = pos[0];
                        int nc = pos[1];

                        if (currentDist < dist[nr][nc]) {

                            dist[nr][nc] = currentDist;

                            // Cost 0 → front
                            deque.addFirst(new int[]{nr, nc});
                        }
                    }
                }
            }

            // -------------------------
            // NORMAL MOVEMENT - COST 1
            // -------------------------
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (matrix[nr].charAt(nc) == '#') {
                    continue;
                }

                int newDist = currentDist + 1;

                if (newDist < dist[nr][nc]) {

                    dist[nr][nc] = newDist;

                    // Cost 1 → back
                    deque.addLast(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}