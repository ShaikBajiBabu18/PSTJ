import java.io.*;
import java.util.*;

public class Solution {

    /*
     * For each rotation we need the longest palindromic substring.
     *
     * 1. Duplicate the string so every rotation becomes a length-n window.
     * 2. Run Manacher on the transformed doubled string.
     * 3. Build an RMQ (sparse table) over Manacher radii.
     * 4. Binary-search the answer for each rotation.
     *
     * Complexity: O(n log n) time and O(n log n) memory.
     */

    private static class SparseTable {
        private final int[][] table;
        private final int[] log;

        SparseTable(int[] values) {
            int n = values.length;

            log = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            int levels = log[n] + 1;
            table = new int[levels][n];

            System.arraycopy(values, 0, table[0], 0, n);

            for (int k = 1; k < levels; k++) {
                int length = 1 << k;
                int half = length >> 1;

                for (int i = 0; i + length <= n; i++) {
                    table[k][i] = Math.max(
                            table[k - 1][i],
                            table[k - 1][i + half]
                    );
                }
            }
        }

        int queryMax(int left, int right) {
            if (left > right) {
                return 0;
            }

            int len = right - left + 1;
            int k = log[len];

            return Math.max(
                    table[k][left],
                    table[k][right - (1 << k) + 1]
            );
        }
    }

    private static int[] buildManacherRadii(String s) {
        int n = s.length();

        // Transformed string:
        // "abba" -> "^#a#b#b#a#$"
        // Radius in this transformed string equals palindrome length
        // in the original string.
        char[] t = new char[2 * n + 3];

        int pos = 0;
        t[pos++] = '^';

        for (int i = 0; i < n; i++) {
            t[pos++] = '#';
            t[pos++] = s.charAt(i);
        }

        t[pos++] = '#';
        t[pos] = '$';

        int[] radius = new int[t.length];
        int center = 0;
        int right = 0;

        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]);
            }

            while (i + radius[i] + 1 < t.length &&
                   i - radius[i] - 1 >= 0 &&
                   t[i + radius[i] + 1] == t[i - radius[i] - 1]) {
                radius[i]++;
            }

            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }
        }

        return radius;
    }

    private static int solveRotation(
            int start,
            int n,
            SparseTable rmq) {

        // Character positions in transformed string are:
        // 1, 3, 5, ... for the doubled string.
        int left = 2 * start + 1;
        int right = 2 * (start + n - 1) + 1;

        int low = 1;
        int high = n;
        int answer = 1;

        while (low <= high) {
            int length = (low + high) >>> 1;

            /*
             * A palindrome of length 'length' fitting inside this
             * rotation must have its transformed center in:
             *
             * [left + length - 1, right - length + 1]
             *
             * If the maximum Manacher radius in that range is >= length,
             * such a palindrome exists.
             */
            int centerLeft = left + length - 1;
            int centerRight = right - length + 1;

            if (centerLeft <= centerRight &&
                rmq.queryMax(centerLeft, centerRight) >= length) {
                answer = length;
                low = length + 1;
            } else {
                high = length - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        // Two copies are enough to contain every rotation as a window.
        String doubled = s + s;

        int[] radius = buildManacherRadii(doubled);
        SparseTable rmq = new SparseTable(radius);

        StringBuilder out = new StringBuilder();

        for (int start = 0; start < n; start++) {
            out.append(solveRotation(start, n, rmq)).append('\n');
        }

        System.out.print(out);
    }
}
