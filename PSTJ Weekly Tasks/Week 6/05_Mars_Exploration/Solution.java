import java.io.*;

public class Solution {

    private static int marsExploration(String s) {
        String pattern = "SOS";
        int changed = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != pattern.charAt(i % 3)) {
                changed++;
            }
        }

        return changed;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        System.out.println(marsExploration(s));
    }
}
