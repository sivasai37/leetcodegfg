
class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, vis, i, 0);
            dfs(grid, vis, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, vis, 0, j);
            dfs(grid, vis, m - 1, j);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }

        return count;
    }
    private void dfs(int[][] grid, boolean[][] vis, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n ||
            grid[r][c] == 1 || vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        for (int k = 0; k < 4; k++) {
            dfs(grid, vis, r + dr[k], c + dc[k]);
        }
    }
}
