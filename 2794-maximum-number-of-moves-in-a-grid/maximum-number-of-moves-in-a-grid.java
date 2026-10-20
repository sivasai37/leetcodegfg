import java.util.*;

class Solution {
    int[][] dp;
    int[] dx = {-1, 0, 1};
    int[] dy = {1, 1, 1};

    int solve(int i, int j, int[][] grid) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxSteps = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int k = 0; k < 3; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni >= 0 && ni < m && nj < n
                    && grid[ni][nj] > grid[i][j]) {
                maxSteps = Math.max(
                    maxSteps, 1 + solve(ni, nj, grid)
                );
            }
        }

        return dp[i][j] = maxSteps;
    }

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, solve(i, 0, grid));
        }

        return ans;
    }
}