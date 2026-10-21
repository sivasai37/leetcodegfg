class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n];
        dist[start_node] = 1.0;
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int i = 0;
        for (int[] e : edges) {
            adj.get(e[0]).add(new double[] { e[1], succProb[i] });
            adj.get(e[1]).add(new double[] { e[0], succProb[i] });
            i++;
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        pq.add(new double[]{ start_node, 1.0 });
        while (!pq.isEmpty()) {
            double[] arr = pq.poll();
            int u = (int) arr[0];
            double d = arr[1];
            if (u == end_node)
                return d;
            for (double[] it : adj.get(u)) {
                int v = (int) it[0];
                double wt = it[1];
                if (dist[v] < wt * dist[u]) {
                    dist[v] = wt * dist[u];
                    pq.add(new double[] { v, dist[v] });
                }
            }
        }
        return 0.0;

    }
}