import java.io.*;
import java.util.*;

public class Solution {

    private static int maxSubarraySum(List<Integer> arr) {
        int current = arr.get(0);
        int best = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            current = Math.max(arr.get(i), current + arr.get(i));
            best = Math.max(best, current);
        }

        return best;
    }

    private static int maxSubsequence(List<Integer> arr) {
        int best = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value > 0) {
                best = (best == Integer.MIN_VALUE) ? value : best + value;
            }
            largest = Math.max(largest, value);
        }

        if (best == Integer.MIN_VALUE) {
            return largest;
        }

        return best;
    }

    public static List<Integer> maxSubarray(List<Integer> arr) {
        return Arrays.asList(maxSubarraySum(arr), maxSubsequence(arr));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<Integer> arr = new ArrayList<>();

            while (arr.size() < n) {
                String line = br.readLine();
                if (line == null) break;
                for (String token : line.trim().split("\\s+")) {
                    if (!token.isEmpty()) {
                        arr.add(Integer.parseInt(token));
                    }
                }
            }

            List<Integer> result = maxSubarray(arr);
            out.append(result.get(0)).append(' ').append(result.get(1)).append('\n');
        }

        System.out.print(out);
    }
}
