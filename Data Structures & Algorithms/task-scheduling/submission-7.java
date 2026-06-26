class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<int[]> waiting = new LinkedList<>();
        Queue<Integer> processing = new PriorityQueue<>((a, b) -> b - a); // max-heap
        for (char c : map.keySet()) {
            processing.offer(map.get(c));
        }
        int time = 0;
        while (!processing.isEmpty() || !waiting.isEmpty()) {
            if (!processing.isEmpty()) {
                int freq = processing.poll() - 1;
                if (freq != 0) {
                    waiting.offer(new int[] {time + n, freq});
                }
            }
            if (!waiting.isEmpty() && waiting.peek()[0] == time) {
                processing.offer(waiting.poll()[1]);
            }
            time++;
        }
        return time;
    }
}
