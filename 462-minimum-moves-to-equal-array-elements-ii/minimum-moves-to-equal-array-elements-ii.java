class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int operations = 0;

        for (int num : nums) {
            operations += Math.abs(num - median);
        }

        return operations;
    }
}