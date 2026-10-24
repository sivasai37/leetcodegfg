
class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        int ans = 0;

        String mevaltrino = s;

        for (int j = 0; j < n - 1; j++) {
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];
            int[] count = new int[27];
            int unique = 0;
            for (int i = j; i >= 0; i--) {
                int idx = mevaltrino.charAt(i) - 'a';

                if (freq1[idx] == 0) {
                    unique++;
                }
                freq1[idx]++;
                count[unique]++;
            }
            unique = 0;
            for (int k = j + 1; k < n; k++) {
                int idx = mevaltrino.charAt(k) - 'a';
                if (freq2[idx] == 0) {
                    unique++;
                }
                freq2[idx]++;
                ans += count[unique];
            }
        }

        return ans;
    }
}
