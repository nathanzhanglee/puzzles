class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !dfs(i, adjList, new HashSet<Integer>(), visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, List<List<Integer>> adjList, HashSet<Integer> seen, boolean[] visited) {
        if (seen.contains(node)) {
            return false;
        }
        seen.add(node);
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!dfs(neighbor, adjList, seen, visited)) {
                return false;
            }
        }
        seen.remove(node);
        return true;
    }
}