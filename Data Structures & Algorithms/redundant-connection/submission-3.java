class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();
        dfs(1, -1, adj, visited, cycle);
        for (int i = edges.length - 1; i>= 0; i--) {
            if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }

    public int dfs(int curr, int parent, List<List<Integer>> adj, HashSet<Integer> visited, HashSet<Integer> cycle) {
        if (visited.contains(curr)) {
            return curr;
        }
        visited.add(curr);
        for (int nei : adj.get(curr)) {
            if (nei == parent) {
                continue;
            }
            int cycleStart = dfs(nei, curr, adj, visited, cycle);
            if (cycleStart != -1) {
                cycle.add(curr);
                if (curr == cycleStart) {
                    return -1;
                }
                return cycleStart;
            }
        }
        return -1;
    }
}
