class Solution {
    int[][][] dp;
    int mod = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1)
            return 0;
        dp = new int[m][n][2];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return func(0, 0, grid, 1) % mod;
    }

    int func(int i, int j, int[][] grid, int lr) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || m <= i || j >= n)
            return 0;

        if (i == m - 1 && j == n - 1) {
            return grid[i][j] == 0 ? 1 : 0;
        }
        if (dp[i][j][lr] != -1) {
            return dp[i][j][lr];
        }

        int count = 0;
        if (grid[i][j] == 1) {
            if (lr == 1) {
                count += func(i + 1, j, grid, 0) % mod;
            } else {
                count += func(i, j + 1, grid, 1) % mod;
            }
        } else {
            count += func(i + 1, j, grid, 0) % mod;
            count += func(i, j + 1, grid, 1) % mod;
        }
        return dp[i][j][lr] = count % mod;

    }
}