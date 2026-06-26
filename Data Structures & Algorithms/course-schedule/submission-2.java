class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                sources.add(i);
            }
        }
        int courses = 0;
        while (courses < numCourses) {
            if (sources.size() == 0) {
                return false;
            }
            int source = sources.poll();
            courses++;
            for (int child : adjList.get(source)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    sources.add(child);
                }
            }
        }
        return true;
    }
}