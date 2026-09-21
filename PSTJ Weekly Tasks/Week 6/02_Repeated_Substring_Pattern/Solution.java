class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = buildLPS(s);

        int longestBorder = lps[n - 1];
        int period = n - longestBorder;

        return longestBorder > 0 && n % period == 0;
    }

    private int[] buildLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        return lps;
    }
}
