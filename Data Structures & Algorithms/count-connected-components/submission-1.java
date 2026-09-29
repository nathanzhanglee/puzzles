class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int result = 0;
        while (!nodes.isEmpty()) {
            result++;
            dfs(nodes.iterator().next(), adj, nodes);
        }
        return result;
    }

    public void dfs(int curr, List<List<Integer>> adj, HashSet<Integer> visited) {
        visited.remove(curr);
        for (int neighbor : adj.get(curr)) {
            if (!visited.contains(neighbor)) {
                continue;
            }
            dfs(neighbor, adj, visited);
        }
    }
}
