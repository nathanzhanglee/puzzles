class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashSet<Double> times = new HashSet<>();
        for (int i = 0; i < position.length; i++) {
            double time = ((double) target - position[i]) / speed[i];
            times.add(time); 
        }
        return times.size();
    }
}
