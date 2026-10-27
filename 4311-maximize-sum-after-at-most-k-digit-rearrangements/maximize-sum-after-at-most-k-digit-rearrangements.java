class Solution {
    public long maximizeSum(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        int[] inc = new int[n];
        for (int i = 0; i < n; i++) {
            int val = func(nums[i]);
            inc[i] = val - nums[i];
            sum += nums[i];
        }
        Arrays.sort(inc);
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (inc[i] > 0) {
                sum += inc[i];
                k--;
            }
        }
        return sum;
    }

    int func(int val) {
        String s = String.valueOf(val);
        Character[] arr = new Character[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (a, b) -> b - a);
        String news = "";
        for (char c : arr) {
            news += c;
        }
        return Integer.parseInt(news);
    }
}