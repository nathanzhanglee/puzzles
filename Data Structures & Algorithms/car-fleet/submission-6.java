class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        Stack<Double> finish = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            double dist = (double) (target - pairs[i][0]);
            double time = dist / pairs[i][1];
            if (finish.isEmpty() || time > finish.peek()) {
                finish.push(time);
            }
        }
        return finish.size();
    }
}
