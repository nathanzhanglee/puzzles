class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        Stack<Double> s = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        for (int[] pair : pairs) {
            double finish = (target - pair[0]) / ((double) pair[1]);
            if (s.isEmpty() || s.peek() < finish) {
                s.push(finish);
            }
        }
        return s.size();
    }
}
