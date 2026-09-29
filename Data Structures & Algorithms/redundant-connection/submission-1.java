class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashSet<Integer> nodes = new HashSet<>();
        int[] result = null;
        for (int[] edge : edges) {
            if (nodes.contains(edge[0]) && nodes.contains(edge[1])) {
                result = edge;
                continue;
            }
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        return result;
    }
}
