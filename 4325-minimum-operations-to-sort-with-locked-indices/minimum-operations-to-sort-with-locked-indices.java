class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {

        int n = nums.length;

        int ops = 0;
        int reqK = 0;
        // Bubble Sort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    if (locked[j] == 1) {
                        locked[j] = 0;
                        reqK++;
                    }
                    if (locked[j + 1] == 1) {
                        locked[j + 1] = 0;
                        reqK++;
                    }
                    // Swap
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    ops++;
                }
            }
        }

        if (reqK > k) {
            return -1;
        }

        return ops + reqK;
    }
}