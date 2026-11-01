class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int ops = 0;
        int max = Integer.MAX_VALUE;
        for (int x : nums) {
            max = Math.min(max, x);
        }
        for (int x : nums) {
            ops += x - max;
        }
        return ops;

    }
}