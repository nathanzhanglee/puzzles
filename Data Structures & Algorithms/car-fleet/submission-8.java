class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        Stack<Double> times = new Stack<>();
        for (int[] p : pairs) {
            double time = (target - p[0]) / ((double) p[1]);
            if (times.isEmpty() || times.peek() < time) {
                times.push(time);
            }
        }
        return times.size();
    }
}
