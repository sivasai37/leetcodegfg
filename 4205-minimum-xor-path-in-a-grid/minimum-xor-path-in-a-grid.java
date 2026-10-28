class Solution {

    int ans = Integer.MAX_VALUE;
    boolean[][][] visited;

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        visited = new boolean[m][n][1024];

        dfs(0, 0, grid[0][0], grid);

        return ans;
    }

    void dfs(int i, int j, int xorSoFar, int[][] grid) {

        int m = grid.length, n = grid[0].length;

        // ❗ If already visited with same XOR → skip
        if (visited[i][j][xorSoFar]) return;

        visited[i][j][xorSoFar] = true;

        // ✅ Base case
        if (i == m - 1 && j == n - 1) {
            ans = Math.min(ans, xorSoFar);
            return;
        }

        // Move Down
        if (i + 1 < m) {
            dfs(i + 1, j, xorSoFar ^ grid[i + 1][j], grid);
        }

        // Move Right
        if (j + 1 < n) {
            dfs(i, j + 1, xorSoFar ^ grid[i][j + 1], grid);
        }
    }
}