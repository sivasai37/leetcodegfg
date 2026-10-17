class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                     adj.get(j).add(i);

                }
            }
        }

        boolean[] vis = new boolean[n];
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
                c++;
            }
        }
        return c;
    }
    void dfs(int node,boolean[] vis, List<List<Integer>> adj){
         Queue<Integer> q = new LinkedList<>();
         q.add(node);
         vis[node] = true;
         while(!q.isEmpty()){
            int x = q.poll();
            for(int it:adj.get(x)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }
         }
    }
}