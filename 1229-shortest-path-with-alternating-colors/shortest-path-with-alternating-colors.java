
import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(
            int n, int[][] redEdges, int[][] blueEdges) {

        // Each edge is stored as {destination, color}
        // 0 = red, 1 = blue
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : redEdges) {
            adj.get(e[0]).add(new int[]{e[1], 0});
        }

        for (int[] e : blueEdges) {
            adj.get(e[0]).add(new int[]{e[1], 1});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][] vis = new boolean[n][2];

        // State: {node, lastColor, distance}
        Queue<int[]> q = new LinkedList<>();

        // Initially, either color can be the first edge.
        q.offer(new int[]{0, -1, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int u = curr[0];
            int lastColor = curr[1];
            int dist = curr[2];

            if (ans[u] == -1) {
                ans[u] = dist;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int color = edge[1];

                // Consecutive edges cannot have the same color.
                if (color == lastColor) {
                    continue;
                }

                if (!vis[v][color]) {
                    vis[v][color] = true;
                    q.offer(new int[]{v, color, dist + 1});
                }
            }
        }

        return ans;
    }
}
