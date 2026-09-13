class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            map.putIfAbsent(prerequisites[i][1], new HashSet<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                sources.add(i);
            }
        }
        while (sources.size() != 0) {
            int curr = sources.poll();
            if (map.containsKey(curr)) {
                for (int neighbor : map.get(curr)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        sources.add(neighbor);
                    }
                }
                map.remove(curr);
            }
        }
        return map.isEmpty();
    }
}
