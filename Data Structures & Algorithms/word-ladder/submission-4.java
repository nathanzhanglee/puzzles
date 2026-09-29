class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
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
        for (int i = 0; i < wordList.size(); i++) {
            String curr = wordList.get(i);  
            List<String> neis = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                int diff = 0;
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < curr.length(); k++) {
                    if (curr.charAt(k) != wordList.get(j).charAt(k)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    neis.add(wordList.get(j));
                }
            }    
            map.put(curr, neis);  
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
                    }
                }
            }
        }
        return 0;
    }
}
