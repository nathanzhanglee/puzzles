class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer> nodes = new HashSet<>();
        int[] degrees = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                nodes.remove(i);
                leaves.add(i);
            }
        }
        while (!leaves.isEmpty()) {
            int leaf = leaves.poll();
            for (int neighbor : adj.get(leaf)) {
                degrees[neighbor]--;
                if (degrees[neighbor] == 1) {
                    nodes.remove(neighbor);
                    leaves.add(neighbor);
                }
            }
        }
        return nodes.size() == 0;
    }
}
