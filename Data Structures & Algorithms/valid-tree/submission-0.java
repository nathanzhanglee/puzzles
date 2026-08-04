class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer> seen = new HashSet<>();
        for (int[] edge : edges) {
            seen.add(edge[0]);
            seen.add(edge[1]);
        }
        if (seen.size() != n || edges.length != n - 1) {
            return false;
        }
        return true;
    }
}
