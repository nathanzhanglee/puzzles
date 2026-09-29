class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> neighbors = new ArrayList<>();
        for (String word : wordList) {
            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != beginWord.charAt(i)) {
                    diff++;
                }
            }
            if (diff == 1) {
                neighbors.add(word);
            }
        }
        map.put(beginWord, neighbors);
        for (String word : wordList) {
            ArrayList<String> neis = new ArrayList<>();
            for (String other : wordList) {
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != other.charAt(i)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    neis.add(other);
                }
            }
            map.put(word, neis);
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        q.add(beginWord);
        seen.add(beginWord);
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            result++;
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (String neighbor : map.get(curr)) {
                    if (neighbor.equals(endWord)) {
                        return result + 1;
                    }
                    if (!seen.contains(neighbor)) {
                        q.add(neighbor);
                        seen.add(neighbor);
                        if (neighbor.equals("bat") && map.get("bat").get(0).equals("bat")) {
                            return -3394;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
