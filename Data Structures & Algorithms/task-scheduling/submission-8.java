class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        List<int[]> waiting = new LinkedList<>();
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : freq.keySet()) {
            maxHeap.offer(freq.get(c));
        }
        while (!maxHeap.isEmpty() || waiting.size() != 0) {
            if (!maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                curr--;
                if (curr != 0) {
                    waiting.add(new int[] {curr, time + n});
                }
            }
            if (waiting.size() != 0 && waiting.get(0)[1] == time) {
                maxHeap.offer(waiting.get(0)[0]);
                waiting.remove(0);
            }
            time++;
        }
        return time;
    }
}
