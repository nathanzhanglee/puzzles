class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : tasks) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        int time = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Queue<int[]> q = new LinkedList<>();
        for (char c : m.keySet()) {
            minHeap.add(new int[] {-1 * m.get(c), m.get(c)});
        }
        while (!minHeap.isEmpty()) {
            q.add(minHeap.poll());
        }
        while (!q.isEmpty() || !minHeap.isEmpty()) {
            if (q.isEmpty()) {
                time++;
                while (!minHeap.isEmpty() && minHeap.peek()[0] == time) {
                    q.add(minHeap.poll());
                }
                continue;
            }
            int[] curr = q.poll();
            curr[0] = time + 1 + n;
            curr[1]--;
            if (curr[1] != 0) {
                minHeap.add(curr);
            }
            time++;
        }
        return time;
    }
}
