import java.io.*;

public class Solution {

    private static String twoStrings(String s1, String s2) {
        boolean[] present = new boolean[26];

        for (int i = 0; i < s1.length(); i++) {
            present[s1.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (present[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();

            out.append(twoStrings(s1, s2)).append('\n');
        }

        System.out.print(out);
    }
}
