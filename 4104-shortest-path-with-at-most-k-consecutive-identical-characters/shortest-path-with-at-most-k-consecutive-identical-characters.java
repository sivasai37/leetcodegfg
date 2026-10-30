import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        // 1. Build directed adjacency list
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        // 2. Distance = node + consecutive count
        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 3. PriorityQueue: {node, count, distance}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        // 4. Initial state
        dist[0][1] = 0;
        pq.offer(new int[]{0, 1, 0});

        // 5. Dijkstra
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int u = curr[0];
            int count = curr[1];
            int d = curr[2];

            // Destination reached
            if (u == n - 1) {
                return d;
            }

            // Explore neighbors
            for (int[] edge : adj.get(u)) {

                int v = edge[0];
                int wt = edge[1];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Check constraint
                if (newCount > k) {
                    continue;
                }

                int newDist = d + wt;
                // Relaxation
                if (newDist < dist[v][newCount]) {
                    dist[v][newCount] = newDist;
                    pq.offer(new int[]{
                        v, newCount, newDist
                    });
                }
            }
        }

        return -1;
    }
}