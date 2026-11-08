import java.util.*;

class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;
        int firstMismatch = n - 1;

        // Step 1: Find the first mismatch
        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) {
                firstMismatch = i;
                break;
            }
        }

        // Step 2: Sort the suffix in descending order
        int[] a = Arrays.copyOfRange(nums, firstMismatch, n);

        Arrays.sort(a);

        // Reverse to get descending order
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }

        // Step 3: Compare with target suffix
        for (int i = 0; i < a.length; i++) {
            if (a[i] != target[firstMismatch + i]) {
                return 0;
            }
        }

        // Step 4: Count valid starting indices
        int ans = 1;

        for (int i = firstMismatch; i > 0; i--) {
            if (target[i] > target[i - 1]) {
                break;
            }
            ans++;
        }

        return ans;
    }
}