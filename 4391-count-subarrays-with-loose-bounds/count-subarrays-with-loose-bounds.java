class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long c = 0;

        int l = 0;
        int r = 0;
        for (r = 0; r < n; r++) {
            if (nums[r] >= minK && nums[r] <= maxK) {
                c += r - l + 1;
            }else{
                l =  r + 1;
            }
        }
        return c;

    }
}