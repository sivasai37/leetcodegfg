class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int x:nums){
            max = Math.max(x,max);
        }
        int ans = 0;
        for(int x:nums){
            ans += max - x;
        }
        return ans;

    }
}