class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(i, adj, visited);
            }
        }
        return res;
    }
    
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            dfs(neighbor, adj, visited);
        }
    }
}
