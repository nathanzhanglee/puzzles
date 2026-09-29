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
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            HashSet<Integer> layer = new HashSet<>();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                layer.add(curr);
                visited.add(curr);
                List<Integer> neighbors = graph.get(curr);
                for (int neighbor : neighbors) {
                    if (layer.contains(neighbor)) {
                        return false;
                    }
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    q.add(neighbor);
                }
            }
        }
        return true;
    }
}
