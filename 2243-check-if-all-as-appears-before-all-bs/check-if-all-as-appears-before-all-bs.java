class Solution {
    public boolean checkString(String s) {
        int lastA = s.lastIndexOf('a');
        int firstB = s.indexOf('b');

        if (firstB == -1) {
            return true;
        }
        return lastA < firstB;
    }
}