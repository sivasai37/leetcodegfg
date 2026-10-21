class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 0 });

        int[][] dist = new int[m][n];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int dis = arr[2];

            if (m - 1 == r && n - 1 == c) {
                return dis;
            }

            for (int k = 0; k < 4; k++) {
                int nr = dx[k] + r;
                int nc = dy[k] + c;
                int x = grid[r][c] == k + 1 ? 0 : 1;
                if (nr >= 0 && nc >= 0 && m > nr && n > nc && x + dist[r][c] < dist[nr][nc]) {
                    pq.add(new int[] { nr, nc, x + dist[r][c] });
                    dist[nr][nc] = x + dist[r][c];
                }
            }

        }
        return -1;
    }
}