class Solution {
    public boolean canAliceWin(int n) {
        if (n < 10)
            return false;
        boolean alice = true;
        boolean bob = false;
        int c = 10;

        while (n > 0) {
            if (n >= c) { // 2>=9
                n -= c;//2
                c--;//9
                if (alice) {
                    alice = false;
                } else {
                    alice = true;
                }
            } else {
                if (!alice) {
                    return true;
                } else {
                    return false;
                }

            }

        }
        if (!alice) {
            return true;
        } else {
            return false;
        }

    }
}