class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] nodeToChildren = new HashSet[numCourses];
        HashSet<Integer>[] nodeToParents = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodeToChildren[i] = new HashSet<>();
            nodeToParents[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            nodeToChildren[parent].add(child);
            nodeToParents[child].add(parent);
        }
        int courses = 0;
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < nodeToParents.length; i++) {
            if (nodeToParents[i].isEmpty()) {
                sources.add(i);
            }
        }
        while (courses < numCourses) {
            if (sources.size() == 0) {
                return false;
            }
            int size = sources.size();
            for (int i = 0; i < size; i++) {
                int source = sources.poll();
                courses++;
                for (int child : nodeToChildren[source]) {
                    nodeToParents[child].remove(source);
                    if (nodeToParents[child].isEmpty()) {
                        sources.add(child);
                    }
                }
            }
        }
        return true;
    }
}
