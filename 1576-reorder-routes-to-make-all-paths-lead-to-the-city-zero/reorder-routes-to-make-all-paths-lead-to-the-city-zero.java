
import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {

        List<List<int[]>> adj = new ArrayList<>();

        // 1. Create adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Store each road in both directions
        for (int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];

            adj.get(a).add(new int[]{b, 1});
            adj.get(b).add(new int[]{a, 0});
        }

        // 3. Initialize BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int changes = 0;

        // 4. Traverse the graph using BFS
        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int[] neighbor : adj.get(city)) {
                int nextCity = neighbor[0];
                int cost = neighbor[1];

                if (!visited[nextCity]) {
                    visited[nextCity] = true;

                    changes += cost;

                    queue.offer(nextCity);
                }
            }
        }
        return changes;
    }
}
