class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];

        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
      

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 0 });
       
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int dis = arr[2]; 

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr >= 0 && nc >= 0 && m > nr && n > nc) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int maxEffort = Math.max(diff, dis);
                    if (dist[nr][nc] > maxEffort) {
                        pq.add(new int[] { nr, nc, maxEffort });
                        dist[nr][nc] = maxEffort;
                    }

                }
            }
        }
        return dist[m-1][n-1];

    }
}