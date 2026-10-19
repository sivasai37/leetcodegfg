import java.util.*;

class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (bfs(i, j, grid, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean bfs(int i, int j, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, -1, -1}); // row, col, parent_row, parent_col
        vis[i][j] = true;

        int[][] dirs = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int pr = curr[2];
            int pc = curr[3];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // check bounds
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                // check same character
                if (grid[nr][nc] != grid[r][c]) continue;

                // if not visited → continue BFS
                if (!vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc, r, c});
                }
                // if visited and not parent → cycle found
                else if (nr != pr || nc != pc) {
                    return true;
                }
            }
        }
        return false;
    }
}