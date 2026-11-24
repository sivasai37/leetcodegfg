class Solution {
    public int maxLength(int[] nums) {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            int lcm = 1;
            int gcd = 0;
            
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = (lcm * nums[j]) / gcd(lcm, nums[j]);
                
                // Check if the subarray satisfies the condition
                if (product == gcd * lcm) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // Helper function to calculate GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
