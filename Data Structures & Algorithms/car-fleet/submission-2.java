class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        
        Stack<int[]> s = new Stack<>();
        for (int[] curr : pairs) {
            double time = ((double) target - curr[0]) / curr[1];
            if (!s.isEmpty()) {
                double otherTime = ((double) target - s.peek()[0]) / s.peek()[1];
                if (otherTime >= time) {
                    continue;
                }
            }
            s.push(curr);
        }
        return s.size();
    }
}
