class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            indegree[prereq[0]]++;
            children.get(prereq[1]).add(prereq[0]);
        }
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                sources.add(i);
            }
        }
        List<Integer> toposort = new ArrayList<>();
        while (!sources.isEmpty()) {
            int curr = sources.poll();
            toposort.add(curr);
            for (int child : children.get(curr)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    sources.add(child);
                }
            }
        }
        if (toposort.size() < numCourses) {
            return new int[] {};
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < toposort.size(); i++) {
            res[i] = toposort.get(i);
        }
        return res;
    }
}
