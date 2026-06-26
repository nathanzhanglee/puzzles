class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new int[] {position[i], speed[i]});
        }
        cars.sort((a,b) -> b[0] - a[0]);
        Stack<Double> res = new Stack<>();
        for (int[] curr : cars) {
            int pos = curr[0];
            int spe = curr[1];
            double time = (double) (target - pos) / spe;
            if (res.isEmpty() || res.peek() < time) {
                res.push(time);
            }
        }
        return res.size();
    }
}
