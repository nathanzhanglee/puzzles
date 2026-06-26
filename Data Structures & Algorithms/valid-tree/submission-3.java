class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(0, seen, adj, -1) && seen.size() == n;
    }
    public boolean dfs(int node, HashSet<Integer> seen, List<List<Integer>> adj, int parent) {
        if (seen.contains(node) || parent == node) {
            return false;
        }
        seen.add(node);
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (!dfs(neighbor, seen, adj, node)) {
                return false;
            }
        }
        return true;
    }
}
