class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // Transform:
        // "babad" -> "^#b#a#b#a#d#$"
        // This lets one Manacher array handle odd and even palindromes.
        StringBuilder t = new StringBuilder();
        t.append('^');

        for (int i = 0; i < s.length(); i++) {
            t.append('#');
            t.append(s.charAt(i));
        }

        t.append("#$");

        int n = t.length();
        int[] p = new int[n];

        int center = 0;
        int right = 0;

        int bestCenter = 0;
        int bestLength = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (t.charAt(i + 1 + p[i]) ==
                   t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > bestLength) {
                bestLength = p[i];
                bestCenter = i;
            }
        }

        int start = (bestCenter - bestLength) / 2;
        return s.substring(start, start + bestLength);
    }
}
