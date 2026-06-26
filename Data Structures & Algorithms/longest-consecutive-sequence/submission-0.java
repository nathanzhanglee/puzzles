class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int n : nums) {
            seen.add(n);
        }
        int res = 0;
        while (seen.size() > 0) {
            int currSize = 1;
            int temp = seen.iterator().next();
            int curr = temp;
            seen.remove(temp);
            while (seen.contains(curr - 1)) {
                currSize++;
                curr--;
                seen.remove(curr);
            }
            curr = temp;
            while (seen.contains(curr + 1)) {
                currSize++;
                curr++;;
                seen.remove(curr);
            }   
            res = Math.max(currSize, res);     
        }
        return res;
    }
}
