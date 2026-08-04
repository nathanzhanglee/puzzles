class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> finish = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            double dist = (double) (target - position[i]);
            double time = dist / speed[i];
            if (finish.isEmpty() || time > finish.peek()) {
                finish.push(time);
            }
        }
        return finish.size();
    }
}
