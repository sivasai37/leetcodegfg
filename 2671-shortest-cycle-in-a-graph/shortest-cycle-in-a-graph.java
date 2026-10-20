class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int min = Integer.MAX_VALUE;
        for (int st = 0; st < n; st++) {
            boolean[] vis = new boolean[n];
            Queue<int[]> q = new LinkedList<>();
            vis[st] = true;
            int[] dist = new int[n];
            Arrays.fill(dist,-1);
            dist[st] = 0;
            q.add(new int[]{st,-1});
            while(!q.isEmpty()){
                int[] arr = q.poll();
                int u = arr[0];
                int p = arr[1];
                for(int it:adj.get(u)){
                    if(!vis[it]){
                        dist[it] = dist[u] + 1;
                        q.add(new int[]{it,u});
                        vis[it] = true;
                    }else if(p!=it){
                        min = Math.min(min,dist[u]+dist[it]+1);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}