class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }
        return visited.size() == n;
    }
    public boolean dfs(int curr, int parent, List<List<Integer>> graph, HashSet<Integer> visited) {
        if (visited.contains(curr)) {
            return false;
        }
        visited.add(curr);
        for (int neighbor : graph.get(curr)) {
            if (neighbor == parent) {
                continue;
            }
            if (!dfs(neighbor, curr, graph, visited)) {
                return false;
            }
        }
        return true;
    }
}
