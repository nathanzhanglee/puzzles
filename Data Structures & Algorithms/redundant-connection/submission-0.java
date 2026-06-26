class Solution {
    // int cycleStart = -1;
    // boolean cycle = false;
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> cycle = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();
        dfs(adj, 1, -1, seen, cycle);

        for (int i = edges.length - 1; i >= 0; i--) {
            if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return new int[] {};
    }

    public int dfs(List<List<Integer>> adj, int node, int parent, HashSet<Integer> seen, HashSet<Integer> cycle) {

        if (seen.contains(node)) {
            return node;
        }
        seen.add(node);
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            int cycleStart = dfs(adj, neighbor, node, seen, cycle);
            if (cycleStart != -1) {
                cycle.add(node);
                if (cycleStart == node) {
                    return -1;
                } else {
                    return cycleStart;
                }
            }
        }
        return -1;
    }


}
