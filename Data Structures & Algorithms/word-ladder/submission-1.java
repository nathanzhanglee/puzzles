class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        for (String s : wordList) {
            for (String t : wordList) {
                if (s.equals(t)) {
                    continue;
                }
                int diff = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        diff++;
                    }
                }
                if (diff <= 1) {
                    graph.putIfAbsent(s, new HashSet<>());
                    graph.get(s).add(t);
                }
            }
        }
        if (!graph.containsKey(beginWord)) {
            return 0;
        }
        return bfs(beginWord, endWord, graph);
    }

    public int bfs(String beginWord, String endWord, HashMap<String, HashSet<String>> graph) {
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        seen.add(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (String neighbor : graph.get(curr)) {
                    if (neighbor.equals(endWord)) {
                        return res;
                    }
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }
}
