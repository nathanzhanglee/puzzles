
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet()) {
            heap.offer(map.get(c));
        }
        Queue<Integer> maxHeap = new LinkedList<>();
        while (!heap.isEmpty()) {
            maxHeap.offer(heap.poll());
        }

        while (!q.isEmpty() || !maxHeap.isEmpty()) {
            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll() - 1;
                if (freq > 0) {
                    q.offer(new int[] {freq, time + n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
            time++;
        }
        return time;
    }
}
